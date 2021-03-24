package com.app;

import javax.xml.ws.Endpoint;

import com.app.ws.SubscriberService;
import com.app.ws.impl.SubscriberServiceImpl;

public class WSLauncher {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Endpoint.publish("http://localhost:9090/SubscriberManagement", new SubscriberServiceImpl());
	}

}
