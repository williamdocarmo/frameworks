package com.spring;

public class Circle implements Shape {
	
	private Point center;
	
	public Point getCenter() {
		return center;
	}

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
