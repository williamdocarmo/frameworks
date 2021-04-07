package com.app.lambda.runnable;

public class LambdaThreadDemo {

	public static void main(String[] args) {

		Thread myThread = new Thread(() -> System.out.println("Printed inside Run"));
		myThread.run();
	}

}
