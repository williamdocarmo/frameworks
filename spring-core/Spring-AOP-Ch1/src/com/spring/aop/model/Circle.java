package com.spring.aop.model;

public class Circle {
	
	private String name;
	
	public String getName() {
		System.out.println("Inside Circle getName "+name);
		return name;
	}
	
	public String getType() {
		System.out.println("Inside Circle getType");
		return name;
	}
	
	public void throwError(String message) throws Exception {
		throw new Exception("System Generated Exception: "+message);
	}
	
	public String returnName() {
		return this.name;
	}

	public void setName(String name) {
		System.out.println("Injected name in circle: "+name);
		this.name = name;
	}

	@Override
	public String toString() {
		return "Circle [name=" + name + "]";
	}

	public Boolean authenticate(String username, String password) {
		System.out.println("Username: "+username+", Password: "+password);
		return true;
	}
	
}
