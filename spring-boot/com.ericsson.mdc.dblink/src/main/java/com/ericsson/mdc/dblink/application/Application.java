package com.ericsson.mdc.dblink.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = {
		"com.ericsson.mdc.dblink.soap",
		"com.ericsson.mdc.dblink.services.orm",
		"com.ericsson.mdc.dblink.services.jdbc",
		"com.ericsson.mdc.dblink.framework",
		"com.ericsson.mdc.dblink.service"})
@Configuration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
