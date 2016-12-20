package com.hm.birthday.admin.login.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hm.birthday.admin.worker.service.IWorkerService;
import com.hm.birthday.core.controller.AbstractDisplayController;
import com.hm.birthday.enums.RetMsg;
import com.hm.birthday.utils.MD5Utils;

@Controller
@RequestMapping("admin")
public class AdminLoginController extends AbstractDisplayController {
	
	private final static Logger logger = LoggerFactory.getLogger(AdminLoginController.class);
	
	private String  admin_login = "admin/login";
	
	@Autowired
	private IWorkerService workerService;
	
	@RequestMapping
	public ModelAndView index() {
		return setModelView(admin_login);
	}
	
	@RequestMapping("login.do")
	public ModelAndView adminLogin(@RequestParam Map<String, Object> param, HttpSession session) {
		String userName = (String) param.get("userName");
		String password = (String) param.get("password");
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("userName", userName);
		if (StringUtils.isEmpty(userName)) {
			result.put("result", RetMsg.USER_ANME_NULL.name());
			result.put("info", RetMsg.USER_ANME_NULL.value());
			return setModelView(admin_login, result);
		}
		if (StringUtils.isEmpty(password)) {
			result.put("result", RetMsg.PASSWORD_NULL.name());
			result.put("info", RetMsg.PASSWORD_NULL.value());
			return setModelView(admin_login, result);
		}
		
		try {
			password = MD5Utils.MD5Encoder(password);
			Map<String,Object> loginUser = workerService.login(userName, password);
			
			if (CollectionUtils.isEmpty(loginUser)) {
				result.put("result", RetMsg.USER_PASSWORD_ERROR.name());
				result.put("info", RetMsg.USER_PASSWORD_ERROR.value());
				return setModelView(admin_login, result);
			} else {
				if (!"02".equals(loginUser.get("workerRole"))) {
					result.put("result", RetMsg.AUTH_LIMITED.name());
					result.put("info", RetMsg.AUTH_LIMITED.value());
					return setModelView(admin_login, result);
				}
			}
			
			session.setAttribute("loginUser", loginUser);
			if (loginUser.containsKey("password")) {
				loginUser.remove("password");
			}
			return setModelView("admin/main");
		} catch (Exception e) {
			logger.error("用户登录，获取用户信息失败.", e);
			result.put("result", RetMsg.SYSTEM_ERROR.name());
			result.put("info", RetMsg.SYSTEM_ERROR.value());
			return setModelView(admin_login, result);
		}
	}
	
	@RequestMapping("logout.do")
	public ModelAndView adminLogout(HttpSession session) {
		if (session.getAttribute("loginUser") != null) {
			session.removeAttribute("loginUser");
		}
		return setModelView("admin/login");
	}
}
