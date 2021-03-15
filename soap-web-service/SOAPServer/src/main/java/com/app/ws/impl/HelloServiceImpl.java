package com.app.ws.impl;

import com.app.ws.HelloService;

import jakarta.jws.WebService;

@WebService(endpointInterface = "com.app.ws.HelloService")
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		return "Hello, "+name;
	}

}