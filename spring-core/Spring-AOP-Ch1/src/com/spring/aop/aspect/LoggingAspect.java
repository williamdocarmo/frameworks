package com.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	//Specific method (without argument) in a specific class
	@Before("execution(public String com.spring.aop.model.Triangle.getName())")
	public void BeforeLoggingAdvice() throws Throwable {
		System.out.println("1- BeforeLoggingAdvice");
	}
	
	// All methods starting with get with any return type in any class
	@After("execution(* get*(..))")
	public void AfterLoggingAdvice() throws Throwable {
		System.out.println("2- AfterLoggingAdvice");
	}
	
	// Multiple Argument
	@AfterThrowing("execution(public void com.spring.aop.model.*.throwError(*,*))")
	public void AfterThrowingLoggingAdvice() throws Throwable {
		System.out.println("3- AfterThrowingLoggingAdvice");
	}
	
	@AfterReturning("execution(public String returnName())")
	public void AfterReturningLoggingAdvice() throws Throwable {
		System.out.println("4- AfterReturningLoggingAdvice");
	}
	
	@Around("authenticatePointcut()")
	public void AroundLoggingAdvice(ProceedingJoinPoint joinpoint) throws Throwable {
		System.out.println("5- AroundLoggingAdvice - 1");
		Object object = joinpoint.proceed();
		System.out.println("5- Object: "+object.toString());
		Signature signature = joinpoint.getSignature();
		System.out.println("5- Signature Method Name: "+signature.getName());
		for (Object arg : joinpoint.getArgs()) {
			System.out.println("5- Arguments Passed: "+arg);
		}
		System.out.println("5- AroundLoggingAdvice - 2");
	}
	
	@Before("allTriangleMethods()")
	public void beforeTriangle() {
		System.out.println("6- Going to call a triangle method");
	}
	
	@Before("allStringAcceptor()")
	public void acceptedString() {
		System.out.println("6- Executing a method that accepts String");
	}
	
	@Before("allTriangleStringAcceptor()")
	public void acceptedStringInTriangle() {
		System.out.println("6- Executing a Triangle method that accepts String");
	}
	
	@Pointcut("execution(public Boolean authenticate(..))")
	public void authenticatePointcut() {}
	
	@Pointcut("within(com.spring.aop.model.Triangle)")
	public void allTriangleMethods() {}
	
	@Pointcut("args(String)")
	public void allStringAcceptor() {}
	
	// Combine
	@Pointcut("allTriangleMethods() && allStringAcceptor()")
	public void allTriangleStringAcceptor() {}

}
