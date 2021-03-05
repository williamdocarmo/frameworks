package com.spring.aop.model;

import com.spring.aop.Authentication;

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
		System.out.println("Inside Circle Setter");
		this.name = name;
		if (name.equals("my name"))
			throw new RuntimeException("Exception Happened");
	}
	
	public Circle setAndReturnName(String name) {
		System.out.println("Inside Circle Setter and Returner");
		this.name = name;
		return this;
	}

	@Override
	public String toString() {
		return "Circle [name=" + name + "]";
	}

	public Boolean authenticate(Authentication auth) {
		System.out.println("Username: "+auth.getUsername()+", Password: "+auth.getPassword());
		return true;
	}
	
}
