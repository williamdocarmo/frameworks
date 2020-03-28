package com.reflection.app.util;

public class CommonUtils {
	
	public static String getCurrentDay() {
		return "SUNDAY";
	}
	
	private static void print(String string) {
		System.out.println("Writing "+string );
	}
	
	public static int calculateSum(int num1, Integer num2) {
		return num1+num2;
	}
	
}
