package com.app.lambda.basics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Greeter {
	
	public static void main(String[] args) {

		Greeting greetingFunction = () -> System.out.println("Hello World!");
		greetingFunction.perform();
		
		Function<Integer, Integer> dnf = (a) -> a * 2;
		
		System.out.println("Multiplication: "+dnf.apply(5));
		
		AddFunction addFunction = (int a, int b) -> a + b;
		int sum = addFunction.add(5, 10);
		
		List<String> l = Arrays.asList("abc", "abcde", "x");
		l.stream().map(s -> s.length()).forEach(x -> System.out.println(x));
		
	}
	
}

/**
greetingFunction = () -> System.out.println("Hello World");

doubleNumberFunction = (int a) -> a * 2;

addFunction = (int a, int b) -> a + b

safeDivideFunction = (int a, int b) -> {
	if (b == 0) return 0;
	return a/b; 
};

stringLengthFunction -> (String s) -> s.length();

*/