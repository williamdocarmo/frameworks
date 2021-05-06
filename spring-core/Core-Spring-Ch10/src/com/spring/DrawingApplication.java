package com.spring;

import java.util.Locale;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DrawingApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		context.registerShutdownHook();
		
		Shape shape = null;
		
		shape = context.getBean("circle", Circle.class);
		shape.draw();
		
		String message = context.getMessage("circle.greeting", new String[] {"10", "20"}, "Default Greeting", Locale.ENGLISH);
		System.out.println("Message: "+message);
		
		
		Point anotherPoint = context.getBean("center", Point.class);
		System.out.println("AnotherPoint: "+anotherPoint);
		
		CustomShape cshape = context.getBean("customShape", CustomShape.class);
		System.out.println("cshape: "+cshape);
		
		context.close();
	}

}
