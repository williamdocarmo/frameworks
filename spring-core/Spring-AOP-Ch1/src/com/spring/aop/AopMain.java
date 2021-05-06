package com.spring.aop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.model.Circle;
import com.spring.aop.model.Triangle;

public class AopMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
		
		//After Advice, Before Advice
		Triangle triangle = shapeService.getTriangle();
		String triangleName = triangle.getName();
		
		Circle circle = shapeService.getCircle();
		//String circleName = circle.getName();
		
		//String circleType = circle.getType();
		
		// AfterThrowing Advice
		try {
			circle.throwError("error");
		} catch (Exception e) {
			System.out.println("Caught Exception");
		}
		
		// AfterReturning Advice
		circle.returnName();
		
		// Around Advice
		circle.authenticate("myusername", "mypassword");
		System.out.println("Name Retrieved: "+triangleName);
		
		triangle.processTriangle();
		
		triangle.processTriangle("");
		
		System.out.println("Going to test Annotation based Pointcut");
		
		Circle c = shapeService.getCircle();
		
	}

}
