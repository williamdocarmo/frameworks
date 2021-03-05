package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component (value = "circle")
public class Circle implements Shape {
	
	@Autowired
	private MessageSource messageSource;
	
	private Point center;

	@Autowired
	public void setCenter(Point center) {
		this.center = center;
	}

	public void draw() {
		String message = this.messageSource.getMessage("circle.greeting", new Object[] {center.getX(), center.getY()}, "Default Greeting", null);
		System.out.println(message);
	}
	
	@Override
	public String toString() {
		return "[center=" + center + "]";
	}
	
}