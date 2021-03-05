package com.spring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Triangle implements Shape {
	
	private Point pointA;
	
	private Point pointB;
	
	private Point pointC;
	
	@Resource
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	@Autowired
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	@Resource (name = "pointZ")
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
