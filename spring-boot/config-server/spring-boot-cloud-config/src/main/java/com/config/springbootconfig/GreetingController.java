package com.config.springbootconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingController {
	
	private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

	@Autowired
	private DBSettings dbSettings;

	@RequestMapping("/greeting")
	public String greetUser() {
		String message = "";
		message += dbSettings.getConnection()+ " "+dbSettings.getHost()+" "+dbSettings.getPort()+ "<br />";
		return message;
	}

}
