package com.spring;

import java.util.Locale;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApplication {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		
		Shape shape = null;
		
		shape = context.getBean("circle", Circle.class);
		shape.draw();
		
		String message = context.getMessage("circle.greeting", new String[] {"10", "20"}, "Default Greeting", Locale.ENGLISH);
		System.out.println("Message: "+message);
	}

}
