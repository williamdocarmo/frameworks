package com.app.main;

import com.app.libclasses.ServerContext;

public class ServerHandler {
	
	private static ServerHandler serverHandler;
	
	private ServerHandler() {
		if (null == serverContext) {
			serverContext = new ServerContext();
		}
	}
	
	public static ServerHandler getInstance() {
		if (null == serverHandler)
			serverHandler = new ServerHandler();
		return serverHandler;
	}
	
	private ServerContext serverContext;
	
	public ServerContext getServerContext() {
		return this.serverContext;
	}
	
	public void setServerContext(ServerContext serverContext) {
		this.serverContext = serverContext;
	}

}
