package com.hm.birthday.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter extends AbstractFilter {

	private final static Logger logger = LoggerFactory.getLogger(LoginFilter.class);
	
	private String[] unFileter = new String[]{"admin"};
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		
		
		logger.info(request.getRequestURI());
		// HttpSession session = request.getSession(true);
		// Map<String,Object> loginUser = (Map<String, Object>)
		// session.getAttribute("loginUser");
		// if (CollectionUtils.isEmpty(loginUser)){
		// request.setCharacterEncoding("UTF-8");
		// response.setCharacterEncoding("UTF-8");
		// PrintWriter out = response.getWriter();
		// String loginPage = "/birthday";
		// StringBuilder builder = new StringBuilder();
		// builder.append("<script type=\"text/javascript\">");
		// builder.append("alert('网页过期，请重新登录！');");
		// builder.append("window.top.location.href='");
		// builder.append(loginPage);
		// builder.append("';");
		// builder.append("</script>");
		// out.print(builder.toString());
		// } else {
		// chain.doFilter(request, response);
		// }
	}

}
