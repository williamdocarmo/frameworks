package com.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.spring.aop.Authentication;
import com.spring.aop.model.Circle;

@Aspect
@Component
public class LoggingAspect {
	
	
	@Before("args(com.spring.aop.Authentication)")
	public void BeforeLoggingAdvice(JoinPoint joinPoint) throws Throwable {
		System.out.println("1- BeforeLoggingAdvice");
		System.out.println("1- JoinPoint: "+joinPoint);
		System.out.println("1- JoinPoint Target: "+joinPoint.getTarget());
		Object args[] = joinPoint.getArgs();
		for (Object obj : args) {
			System.out.println("1- Argument: "+obj.toString());
		}
	}
	
	@Around("@annotation(com.spring.aop.aspect.Loggable)")
	public Object loggableAdvice(ProceedingJoinPoint joinpoint) throws Throwable {
		System.out.println("6- Annotation Based Starts");
		Object object = joinpoint.proceed();
		System.out.println("6- Annotation Based Ends");
		return object;
	}
	
	
	@Before("args(param)")
	public void BeforeLoggingAdvice(Authentication param) throws Throwable {
		System.out.println("2- BeforeLoggingAdvice "+param);
	}
	
	@Before("args(param)")
	public void BeforeLoggingAdvice(String param) throws Throwable {
		System.out.println("3- BeforeLoggingAdvice "+param);
	}
	
	@AfterThrowing(pointcut="args(name)", throwing="exc")
	public void handleException (String name, Exception exc) {
		System.out.println("4- Inside Exception Handler: "+exc.getMessage());
		
	}
	
	@AfterReturning(pointcut= "args(name)", returning = "returnObj")
	public void handleReturnObject (String name, Object returnObj) {
		System.out.println("5- Inside handleReturnObject: "+returnObj);
	}
	
}
