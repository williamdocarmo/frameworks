package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Triangle implements Shape {
	
	@Autowired
	private Point pointA;
	
	@Autowired
	private Point pointB;
	
	private Point pointC;
	
	@Autowired
	@Qualifier(value = "circleRelated")
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	@Override
	public void draw() {
		System.out.println("Drawn a Triangle "+this);

	}

	@Override
	public String toString() {
		return "[pointA=" + pointA + ", pointB=" + pointB + ", pointC=" + pointC + "]";
	}

}
