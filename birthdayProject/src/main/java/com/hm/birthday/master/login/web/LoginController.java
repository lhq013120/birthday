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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.birthday.admin.worker.service.IWorkerService;
import com.hm.birthday.admin.worker.web.WorkerController;
import com.hm.birthday.core.controller.AbstractDisplayController;
import com.hm.birthday.enums.RetMsg;

@Controller()
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
	@RequestMapping("login")
	public String login(@RequestParam String userName, @RequestParam String password, HttpSession session) {
		Map<String,Object> result = new HashMap<String, Object>();
		if (StringUtils.isEmpty(userName)) {
			result = setResultMap(RetMsg.USER_ANME_NULL.code());
			return result.toString();
		}
		if (StringUtils.isEmpty(password)) {
			result = setResultMap(RetMsg.PASSWORD_NULL.code());
			return result.toString();
		}
		
		try {
			Map<String,Object> loginUser = workerService.login(userName, password);
			if (CollectionUtils.isEmpty(loginUser)) {
				// TODO 返回值有问题
				result = setResultMap(RetMsg.USER_PASSWORD_ERROR.code());
				return result.toString();
			}
			session.setAttribute("loginUser", loginUser);
			result = setResultMap("userinfo", loginUser);
			workerService.setFirstLogin((Integer)loginUser.get("id")); // 修改首次登陆
			return result.toString();
		} catch (Exception e) {
			result = setResultMap(RetMsg.SYSTEM_ERROR.code());
			logger.error("用户登录，获取用户信息失败.", e);
			return result.toString();
		}
	}
	
	/**
	 * 用户登出
	 * 
	 * @param session
	 * @return
	 */
	public String loginOut(HttpSession session) {
		if (session.getAttribute("loginUser") != null) {
			session.removeAttribute("loginUser");
		}
		return setResultMap(RetMsg.SUCCESS).toString();
	}
	
}
