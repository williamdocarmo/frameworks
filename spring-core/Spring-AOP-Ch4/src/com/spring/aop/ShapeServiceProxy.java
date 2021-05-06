package com.spring.aop;

import com.spring.aop.aspect.LoggingAspect;
import com.spring.aop.model.Circle;

public class ShapeServiceProxy extends ShapeService {
	
	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}

}
