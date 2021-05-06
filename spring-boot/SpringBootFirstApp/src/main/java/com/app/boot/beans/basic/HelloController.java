package com.app.boot.beans.basic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping ("/hello")
	public String sayHello(@RequestParam(defaultValue = "User", name = "username") String name) {
		return "Hello, "+name;
	} 

}
