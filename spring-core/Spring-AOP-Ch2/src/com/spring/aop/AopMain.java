package com.spring.aop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.model.Circle;
import com.spring.aop.model.Triangle;

public class AopMain {

	public static void main(String[] args) throws InterruptedException {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
		System.out.println("Shape Service: "+shapeService);
		
		//After Advice, Before Advice
		Triangle triangle = shapeService.getTriangle();
		Circle circle = shapeService.getCircle();
		triangle.getName();
		System.out.println("Circle: "+circle);
		circle.authenticate(new Authentication ("myuser", "mypass"));
		
		try{
			circle.setName("circle name");
		} catch (Exception e) {
			System.out.println("Caught Exception");
		}
		
		circle.setAndReturnName("my name");
		
		circle.getName();
		
		System.out.println("Going to test annotation based");
		
		Circle c1 = shapeService.getCircle();
	}

}
