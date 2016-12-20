package com.hm.birthday.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户登录过滤器
 * 
 * @author hanyd
 *
 */
public class LoginFilter extends AbstractFilter {

	private final static Logger logger = LoggerFactory.getLogger(LoginFilter.class);
	
	private final static String admin_login_url = "admin/login.do";
	private final static String admin_logout_url = "admin/logout.do";
	private final static String master_login_url = "user/login.do";
	private final static String master_logout_url = "user/logout.do";
	
	// 不进行过滤的请求url
	private final static String[] unFileter = new String[]{"admin/login.html", "admin","admin/", 
			admin_login_url,
			admin_logout_url,
			master_login_url,
			master_logout_url};
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		String reqUrl = request.getRequestURI();
		logger.info("reqUrl ： {}" , reqUrl);
		String header = request.getHeader("X-Requested-With");
		logger.info("header ： {}" , header);
		boolean isUnFileter = false;
		for(String unFileterUrl : unFileter) {
			if(reqUrl.endsWith(unFileterUrl)) { // 是否包含不过滤URL
				isUnFileter = !isUnFileter;
				break;
			}
		}
		if (isUnFileter) { // 不过滤的路径
			chain.doFilter(request, response);
		} else {
			HttpSession session = request.getSession(true);
			Map<String,Object> loginUser = (Map<String, Object>) session.getAttribute("loginUser");
			if (loginUser == null ) { // 判断用户是否登录
				// 判断用户的ajax访问
				if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
					PrintWriter out = response.getWriter();
					out.println("{\"statusCode\":\"301\", \"message\":\"访问超时请重新登录！\"}");
					
				} else {
					String forworUrl = request.getContextPath() +"/admin";
					response.sendRedirect(forworUrl);
				}
			} else {
				chain.doFilter(request, response);
			}
		}
	}
}
