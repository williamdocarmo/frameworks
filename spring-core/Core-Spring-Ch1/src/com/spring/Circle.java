package com.spring;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Circle implements InitializingBean, DisposableBean, BeanNameAware {
	
	private int radius;
	
	private String type;
	
	private String beanName;
	
	public Circle(int radius, String type) {
		super();
		this.radius = radius;
		this.type = type;
	}

	public void draw() {
		System.out.println("Triangle Drawn with Side: "+this);
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", type=" + type + "]";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Properties have been set for "+beanName);
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroying Bean "+this.beanName);
		
	}
	
}
