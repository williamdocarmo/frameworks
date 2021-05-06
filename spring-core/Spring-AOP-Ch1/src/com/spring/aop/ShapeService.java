package com.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.aop.model.Circle;
import com.spring.aop.model.Triangle;

@Component("shapeService")
public class ShapeService {
	
	
	private Circle circle;
	
	@Autowired
	private Triangle triangle;
	
	@Autowired
	public void setCircle (Circle circle) {
		System.out.println("Injecting Circle: "+circle);
		this.circle = circle;
	}
	
	public Circle getCircle() {
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
