package com.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	public LoginServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Inside LoginServlet.doPost");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("Credentials Passed: "+username+" "+password);
		boolean auth = false;
		if (null!=username && username.equals("santanu") && null!= password && password.equals("pass@123")) {
			auth = true;
		}
		if (auth) {
			/**
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("/Profile").forward(request, response);
			*/
			Cookie cookie = new Cookie("username", username);
			response.addCookie(cookie);
			response.sendRedirect(request.getContextPath()+"/Profile");
		} else {
			System.out.println("Forward");
			request.getRequestDispatcher("/login.html").forward(request, response);
		}
	}
	
}
