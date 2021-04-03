package com.config.springbootconfig;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

	// Default value
	@Value("${greeting.message: Default Hello World}")
	private String greetingMessage;
	
	// List values
	@Value("${my.list.values}")
	private List<String> listValues;
	
	@Autowired
	private DBSettings dbSettings;

	@RequestMapping("/{user}")
	public String greetUser(@PathVariable(name = "user") String username) {
		String message = "";
		message += dbSettings.getConnection()+ " "+dbSettings.getHost()+" "+dbSettings.getPort()+ "<br />";
		return message;
	}

}
