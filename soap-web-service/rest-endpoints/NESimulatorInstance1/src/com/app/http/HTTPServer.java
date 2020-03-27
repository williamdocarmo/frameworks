package com.app.http;

import java.net.InetSocketAddress;

import com.app.http.handler.HandlerFactory;
import com.app.utils.ApplicationConstants;
import com.app.utils.CommonUtils;
import com.sun.net.httpserver.HttpServer;

public class HTTPServer {
	
	private HTTPServer(){}
	
	public static void start() throws Exception {
		CommonUtils.printLogs("Starting up HTTP Server...");
		CommonUtils.printLogs("-------------------------------");
		HttpServer server = HttpServer.create(new InetSocketAddress(ApplicationConstants.HTTP_PORT), 0);
		for (String context : HttpUtils.getContextPaths()) {
			CommonUtils.printLogs("Creating context: "+"/"+context);
			//server.createContext("/" + context, HandlerFactory.getHandler(context));
			server.createContext("/" + context, HandlerFactory.getHandler());
		}
		server.start();
		CommonUtils.printLogs("-------------------------------------------------");
	}

}
