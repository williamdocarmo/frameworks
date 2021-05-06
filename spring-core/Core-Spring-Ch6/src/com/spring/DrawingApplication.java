package com.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApplication {

	public static void main(String[] args) {
		// BeanFactory factory = new XmlBeanFactory(new("spring.xml"));
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		
		Shape shape = null;
		
		shape = context.getBean("circle", Circle.class);
		shape.draw();
		
		shape = context.getBean("triangle", Triangle.class);
		shape.draw();
		
	}

}
