package com.app;

import javax.xml.ws.Endpoint;

import com.app.ws.impl.GreetingAddressService;
import com.app.ws.impl.GreetingsServiceUsingMessageProvider;
import com.app.ws.impl.GreetingsServiceUsingSourceProvider;
import com.app.ws.impl.ImageDownloadServiceProvider;
import com.app.ws.impl.ImageUploadServiceProvider;
import com.app.ws.impl.StreamingMTOM;
import com.app.ws.impl.SubscriberServiceImpl;

public class WSLauncher {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Endpoint.publish("http://localhost:9090/SubscriberManagement", new SubscriberServiceImpl());
		Endpoint.publish("http://localhost:9090/GreetingsSourceProvider", new GreetingsServiceUsingSourceProvider());
		Endpoint.publish("http://localhost:9090/GreetingsMessageProvider", new GreetingsServiceUsingMessageProvider());
		Endpoint.publish("http://localhost:9090/DownloadImage", new ImageDownloadServiceProvider());
		Endpoint.publish("http://localhost:9090/UploadImage", new ImageUploadServiceProvider());
		Endpoint.publish("http://localhost:9090/StreamingMTOMService", new StreamingMTOM());
		Endpoint.publish("http://localhost:9090/GreetingAddressService", new GreetingAddressService());
	}

}