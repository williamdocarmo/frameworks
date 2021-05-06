package com.app.ws.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

import com.app.exc.InvalidUsernameException;

@WebService(serviceName = "GreetingAddressed", name = "GreetingPort", portName = "Greeting", targetNamespace = "http://greet.app.com/")
@Addressing(enabled = true, required = false)
public class GreetingAddressService {
	
	@WebMethod(operationName = "greetUser", action = "http://greet.app.com/greetUser")
	@WebResult(name = "greetingMessage")
	public String sayHello(@WebParam(name = "User") String username) throws InvalidUsernameException {
		if (username == null || "".equals(username)) {
			throw new InvalidUsernameException(3000, "INVALID_USER", "Provide a valid user name");
		}
		return "Hello, "+username;
	}

}
