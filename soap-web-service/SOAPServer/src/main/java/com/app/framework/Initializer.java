package com.app.framework;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class Initializer implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		ContextHolder.getContextHolder().setContext(new ClassPathXmlApplicationContext("spring.xml"));
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {
		
	}

}
