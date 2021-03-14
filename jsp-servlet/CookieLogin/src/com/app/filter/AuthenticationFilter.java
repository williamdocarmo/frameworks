package com.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("AuthenticationFilter.doFilter");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		// HttpSession session = httpRequest.getSession();
		String servletPath = httpRequest.getServletPath();
		// String username = (String) session.getAttribute("username");
		
		Cookie[] cookies = httpRequest.getCookies();
		String username = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("username")) {
				username = cookie.getValue();
			}
		}
		System.out.println("Username: "+username+" ServletPath: "+servletPath);
		if (null == username && !servletPath.equals("/login.html") && !servletPath.equals("/Login")) {
			httpRequest.getRequestDispatcher("/login.html").forward(httpRequest, httpResponse);
		} else {
			chain.doFilter(httpRequest, httpResponse);
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
