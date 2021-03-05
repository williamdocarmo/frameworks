package com.spring;

import org.springframework.beans.factory.annotation.Required;

@SuppressWarnings("deprecation")
public class Circle implements Shape {
	
	private Point center;
	
	@Required 
	public void setCenter(Point center) {
		this.center = center;
	}

	public void draw() {
		System.out.println("Drawn a Circle "+this);
	}

	@Override
	public String toString() {
		return "[center=" + center + "]";
	}
	
}
