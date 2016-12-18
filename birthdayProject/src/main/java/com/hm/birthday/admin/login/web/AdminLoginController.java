package com.hm.birthday.admin.login.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hm.birthday.core.controller.AbstractDisplayController;

@Controller
@RequestMapping("admin")
public class AdminLoginController extends AbstractDisplayController {
	
	@RequestMapping
	public ModelAndView index() {
		return setModelView("admin/login");
	}
	
	@RequestMapping("login.do")
	public ModelAndView adminLogin(@RequestParam String userName, @RequestParam String password, HttpSession session) {
		
		return setModelView("admin/main");
	}
	
	@RequestMapping("logout.do")
	public ModelAndView adminLogout() {
		return setModelView("admin/login");
	}
}
