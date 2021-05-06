package com.app.lambda.closure;

import java.util.function.Consumer;

public class ClosureExample {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;

		doProcess(a, x -> System.out.println(b + x));
		
		doProcess(a, x -> System.out.println(b + x));
	}

	private static void doProcess(int a, Consumer<Integer> consumer) {
		consumer.accept(a);
	}

}