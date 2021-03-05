package com.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApplication {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		// Error- Bean is abstract
		// Triangle parentTriangle = context.getBean("parent-triangle", Triangle.class);
		// parentTriangle.draw();
		
		Triangle triangle1 = context.getBean("triangle1", Triangle.class);
		triangle1.draw();
		
		Triangle triangle2 = context.getBean("triangle2", Triangle.class);
		triangle2.draw();
		
		Triangle triangle3 = context.getBean("triangle3", Triangle.class);
		triangle3.draw();
		
		
	}

}
