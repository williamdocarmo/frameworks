package com.app.lambda.exceptions;

import java.util.function.BiConsumer;

public class ExceptionHandling {

	public static void main(String[] args) {

		int[] keys = { 1, 2, 5, 0, 10, 6 };

		int number = 60;

		process(number, keys, wrapperLambda((k, v) -> System.out.println("Result is: " + (k / v))));

	}

	private static void process(int number, int[] keys, BiConsumer<Integer, Integer> consumer) {
		for (int key : keys) {
			consumer.accept(number, key);
		}
	}
	
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (k, v) ->{
			try {
				consumer.accept (k, v);
			} catch (Exception e) {
				System.out.println("Exception while dividing with "+v);
			}
		};
	}

}