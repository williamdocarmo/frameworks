package com.app.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication (scanBasePackages = {"com.app.boot.beans.topics", "com.app.boot.beans.courses"})
@EnableJpaRepositories (basePackages = {"com.app.boot.beans"})
@EntityScan("com.app.boot.beans")
public class BootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

}
