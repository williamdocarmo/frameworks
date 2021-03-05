package com.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	
	
	public Object loggableAdvice(ProceedingJoinPoint joinpoint) throws Throwable {
		System.out.println("6- Annotation Based Starts");
		Object object = joinpoint.proceed();
		System.out.println("6- Annotation Based Ends");
		return object;
	}
	
}
