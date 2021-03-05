package com.spring.aop;

import com.spring.aop.model.Circle;
import com.spring.aop.model.Triangle;

public class ShapeService {
	
	private Circle circle;
	
	private Triangle triangle;
	
	public Circle getCircle() {
		System.out.println("Calling Circle Getter");
		return circle;
	}

	public Triangle getTriangle() {
		return triangle;
	}

	@Override
	public String toString() {
		return "ShapeService [circle=" + circle + ", triangle=" + triangle + "]";
	}
	
}
