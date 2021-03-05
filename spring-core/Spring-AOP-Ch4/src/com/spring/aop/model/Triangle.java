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
	
	@Override
	public String toString() {
		return "Triangle [name=" + name + "]";
	}
	
}
