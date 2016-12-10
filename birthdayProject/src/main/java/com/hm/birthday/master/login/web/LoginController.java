package com.hm.birthday.master.login.web;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.birthday.admin.worker.service.IWorkerService;
import com.hm.birthday.admin.worker.web.WorkerController;
import com.hm.birthday.core.controller.AbstractDisplayController;
import com.hm.birthday.enums.RetMsg;
import com.hm.birthday.utils.JsonUtils;

@Controller()
@RequestMapping("user")
public class LoginController extends AbstractDisplayController{
	
	private final static Logger logger = LoggerFactory.getLogger(WorkerController.class);
	
	@Autowired
	private IWorkerService workerService;
	
	/**
	 * 用户登录
	 * 
	 * @param userName
	 * @param password
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@RequestParam String userName, @RequestParam String password, HttpSession session) {
		Map<String,Object> result = new HashMap<String, Object>();
		if (StringUtils.isEmpty(userName)) {
			result = setResultMap(RetMsg.USER_ANME_NULL);
			return JsonUtils.toJsonString(result);
		}
		if (StringUtils.isEmpty(password)) {
			result = setResultMap(RetMsg.PASSWORD_NULL);
			return JsonUtils.toJsonString(result);
		}
		
		try {
			Map<String,Object> loginUser = workerService.login(userName, password);
			if (CollectionUtils.isEmpty(loginUser)) {
				result = setResultMap(RetMsg.USER_PASSWORD_ERROR);
				return JsonUtils.toJsonString(result);
			}
			session.setAttribute("loginUser", loginUser);
			result = setResultMap("userinfo", loginUser);
			workerService.setFirstLogin((Integer)loginUser.get("id")); // 修改首次登陆
			return JsonUtils.toJsonString(result);
		} catch (Exception e) {
			result = setResultMap(RetMsg.SYSTEM_ERROR);
			logger.error("用户登录，获取用户信息失败.", e);
			return JsonUtils.toJsonString(result);
		}
	}
	
	/**
	 * 用户登出
	 * 
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		if (session.getAttribute("loginUser") != null) {
			session.removeAttribute("loginUser");
		}
		return JsonUtils.toJsonString(setResultMap(RetMsg.SUCCESS));
	}
	
}