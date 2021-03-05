package com.spring.aop;

public class AopMain {

	public static void main(String[] args) throws InterruptedException {
		// AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		// ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
		// Circle circle = shapeService.getCircle();
		
		FactoryService factoryService = new FactoryService();
		ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");
		shapeService.getCircle();
	}

}
