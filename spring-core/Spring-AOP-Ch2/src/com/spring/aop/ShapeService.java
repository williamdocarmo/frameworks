package com.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.aop.aspect.Loggable;
import com.spring.aop.model.Circle;
import com.spring.aop.model.Triangle;

@Component
public class ShapeService {
	
	@Autowired
	private Circle circle;
	
	@Autowired
	private Triangle triangle;
	
	@Loggable
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
