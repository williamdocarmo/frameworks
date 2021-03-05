package com.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApplication {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		Triangle triangle = context.getBean("triangle", Triangle.class);
		triangle.draw();
		
		// Singleton illustration
		Circle circle = context.getBean("circle-bean", Circle.class);
		System.out.println("Circle has radius: "+circle.getRadius());
		
		circle.setRadius(100);
		
		Circle circle2 = context.getBean("circle-bean", Circle.class);
		System.out.println("Circle has radius: "+circle2.getRadius());
		
		System.out.println("Circle: "+circle);
		
	}

}
