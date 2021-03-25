package com.app.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.app.beans", "com.app.boot.beans"})
public class BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

}
