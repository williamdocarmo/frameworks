package com.spring;

import java.util.List;

public class Triangle {

	private Point pointA;

	private Point pointB;

	private Point pointC;
	
	private List<Point> points;

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public void draw() {
		System.out.println("Triangle Drawn with Side: " + this);
	}

	@Override
	public String toString() {
		return "Triangle [pointA=" + pointA + ", pointB=" + pointB + ", pointC=" + pointC + ", pointList=" + points + "]";
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

}
