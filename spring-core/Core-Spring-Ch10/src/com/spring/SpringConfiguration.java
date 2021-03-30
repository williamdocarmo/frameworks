package com.spring;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@ComponentScan(basePackages = "com.spring")
public class SpringConfiguration {

	@Bean
	public Point center() {
		Point point = new Point();
		point.setX(5);
		point.setY(10);
		return point;
	}

	@Bean(name = { "anotherPoint", "point1" })
	public Point anotherPoint() {
		Point point = new Point();
		point.setX(25);
		point.setY(210);
		return point;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("messages1");
		return messageSource;
	}

}
