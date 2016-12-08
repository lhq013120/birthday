package com.hm.birthday.master.login.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hm.birthday.core.controller.AbstractDisplayController;

@Controller()
public class LoginController extends AbstractDisplayController{
	
	
	@RequestMapping("login")
	public String login() {
		Map<String,Object> modelMap = new HashMap<String, Object>();
		
		return "";
	}

}
