package com.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

public class Circle implements Shape {
	
	@Autowired
	private Point center;

	public void draw() {
		System.out.println("Drawn a Circle "+this);
	}
	
	@PostConstruct
	public void initCircle() {
		System.out.println("Circle being initialized..");
	}
	
	@PreDestroy
	public void destroyCircle() {
		System.out.println("Circle being destroyed..");
	}

	@Override
	public String toString() {
		return "[center=" + center + "]";
	}
	
}
