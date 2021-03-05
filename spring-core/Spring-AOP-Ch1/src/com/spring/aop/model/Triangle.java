package com.spring.aop.model;

public class Triangle {
	
	private String name;

	public String getName() {
		System.out.println("Inside Triangle getName "+name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void processTriangle() {
		System.out.println("Inside process triangle method");
	}
	
	public void processTriangle(String name) {
		System.out.println("Inside process triangle method with String arg");
	}
	
	@Override
	public String toString() {
		return "Triangle [name=" + name + "]";
	}
	
	
	
}
