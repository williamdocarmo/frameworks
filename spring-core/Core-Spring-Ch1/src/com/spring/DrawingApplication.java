package com.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApplication {

	public static void main(String[] args) {
		// BeanFactory factory = new XmlBeanFactory(new("spring.xml"));
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		
		Triangle triangle = context.getBean("triangle", Triangle.class);
		triangle.draw();
		
		Circle circle1 = context.getBean("circle1", Circle.class);
		circle1.draw();
		
		Circle circle2 = context.getBean("circle2", Circle.class);
		circle2.draw();
		
		Triangle triangleAlias = context.getBean("triangle-alias", Triangle.class);
		System.out.println("Both are same bean: "+(triangleAlias.equals(triangle)));
		
	}

}
