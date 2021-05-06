package com.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Circle implements ApplicationContextAware, BeanNameAware {
	
	private int radius;
	
	private String beanName;
	
	private ApplicationContext applicationContext;

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		Triangle triangle = applicationContext.getBean("triangle", Triangle.class);
		System.out.println("Going to draw triangle again!!");
		triangle.draw();
		return "Circle [radius=" + radius + ", beanName=" + beanName + "]";
		
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}
	
}
