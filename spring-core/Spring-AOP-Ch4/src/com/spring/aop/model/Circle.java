package com.spring.aop.model;

public class Circle {
	
	private String name;
	
	public String getName() {
		System.out.println("Inside Circle getName "+name);
		return name;
	}

	@Override
	public String toString() {
		return "Circle [name=" + name + "]";
	}
	
}
