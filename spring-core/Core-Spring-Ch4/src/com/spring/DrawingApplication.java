package com.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApplication {

	public static void main(String[] args) {
		// BeanFactory factory = new XmlBeanFactory(new("spring.xml"));
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		
		Circle circle = context.getBean("circle", Circle.class);
		circle.draw();
		
	}

}
