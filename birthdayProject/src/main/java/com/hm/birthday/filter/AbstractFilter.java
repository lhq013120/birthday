package com.hm.birthday.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hm.birthday.admin.worker.service.impl.WorkerServiceImpl;

public abstract class AbstractFilter implements Filter {

	protected final Logger logger = LoggerFactory.getLogger(WorkerServiceImpl.class);
	
	private FilterConfig filterConfig;
	
	protected final FilterConfig getFilterConfig(){
		return filterConfig;
	}
	
	protected ServletContext getServletContext() {
		return filterConfig.getServletContext();
	}
	
	public AbstractFilter() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
		logger.info("Initializing filter '" + filterConfig.getFilterName() + "'");
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		if ((!(request instanceof HttpServletRequest)) || (!(response instanceof HttpServletResponse))) {
				throw new ServletException("AbstractFilter just supports HTTP requests");
		}
		
		HttpServletRequest httpReq = (HttpServletRequest)request;
		HttpServletResponse httpRes = (HttpServletResponse)response;
		
		if (shouldNotFilter(httpReq)) {
			chain.doFilter(httpReq, httpRes);
		} else {
			doFilterInternal(httpReq, httpRes, chain);
		}
		
	}
	
	protected abstract void doFilterInternal(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, FilterChain paramFilterChain)
			throws ServletException, IOException;
	
	protected boolean acceptsEncoding(HttpServletRequest request, String name) {
		return containsHeader(request, "Accept-Encoding", name);
	}
	
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		return false;
	}
	
	private boolean containsHeader(HttpServletRequest request, String header, String value) {
		for (Enumeration e = request.getHeaders(header); e.hasMoreElements(); ) {
			String headerValue = (String)e.nextElement();
				if (headerValue.indexOf(value) != -1) {
					return true;
				}
		}
		return false;
	}
}
