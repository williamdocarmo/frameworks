package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomShape {
	
	@Autowired
	private Point center;
	
	@Autowired
	private Point anotherPoint;

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public Point getAnotherPoint() {
		return anotherPoint;
	}

	public void setAnotherPoint(Point anotherPoint) {
		this.anotherPoint = anotherPoint;
	}

	public CustomShape() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomShape(Point center, Point anotherPoint) {
		super();
		this.center = center;
		this.anotherPoint = anotherPoint;
	}

	@Override
	public String toString() {
		return "CustomShape [center=" + center + ", anotherPoint=" + anotherPoint + "]";
	}
	
}
