package com.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.model.UserModel;
import com.app.service.AuthenticationService;

public class AuthenticationController extends HttpServlet {
	
	public AuthenticationController() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AuthenticationService service = new AuthenticationService();
		boolean authenticated = service.authenticate(username, password);
		if (authenticated) {
			session.setAttribute("username", username);
			UserModel user = service.getUser(username, password);
			if (null!= user) {
				session.setAttribute("userinfo", user);
				request.setAttribute("userinfo", user);
				request.setAttribute("greetingMessage", user.getUserName()+" says hello!");
				Cookie cookie = new Cookie("username", username+"fromookie");
				response.addCookie(cookie);
			}
			// response.sendRedirect("Greeting.jsp");
			request.getRequestDispatcher("Greeting.jsp").forward(request, response);
		} else {
			response.sendRedirect("Login.jsp");
		}
		
	}

}
