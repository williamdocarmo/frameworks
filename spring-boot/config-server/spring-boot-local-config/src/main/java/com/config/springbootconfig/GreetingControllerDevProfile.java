package com.config.springbootconfig;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("dev")
public class GreetingControllerDevProfile {
	
	private static final Logger logger = LoggerFactory.getLogger(GreetingControllerDevProfile.class);

	// Default value
	@Value("${greeting.message: Default Hello World}")
	private String greetingMessage;
	
	// List values
	@Value("${my.list.values}")
	private List<String> listValues;
	
	// Map values
	@Value("#{${my.map.values}}")
	private Map<String, String> mapValues;
	
	@Autowired
	private DBSettings dbSettings;

	@RequestMapping("/{user}")
	public String greetUser(@PathVariable(name = "user") String username) {
		String message = "";
		message += dbSettings.getConnection()+ " "+dbSettings.getHost()+" "+dbSettings.getPort()+ "<br />";
		message += greetingMessage + " " + username+" <br />"+listValues.get(1)+" "+mapValues.get("param2");
		return message;
	}

}
