package com.spring;

import java.util.List;
import java.util.Map;

public class Triangle {

	private String type;

	private List<Point> points;

	private Map<String, String> metadata;

	private Point pointA;

	private Point pointB;

	private Point pointC;

	public void setType(String type) {
		this.type = type;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}

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

	public void init() {
		System.out.println("Initializing Triangle");
	}

	public void destroy() {
		System.out.println("Destroying Triangle");
	}

	@Override
	public String toString() {
		return "Triangle [type=" + type + ", points=" + points + ", metadata=" + metadata + ", pointA=" + pointA
				+ ", pointB=" + pointB + ", pointC=" + pointC + "]";
	}

}
