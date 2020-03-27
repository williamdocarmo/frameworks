package com.app.http.handler;

import com.sun.net.httpserver.HttpHandler;

public class HandlerFactory {

	public static HttpHandler getHandler(String... handler) {
		if (null != handler && handler.length > 0) { //Special Handling
			if (handler[0].equals("cai3gSession"))
				return Cai3gSessionHandler.getInstance();
			else if (handler[0].equals("createSuccess"))
				return CreateSuccessHandler.getInstance();
			else if (handler[0].equals("jsonError"))
				return JsonErrorHandler.getInstance();
			else	//Default Handling
				return DefaultHandler.getInstance();
		}
		else	//Default Handling
			return DefaultHandler.getInstance();
	}

}
