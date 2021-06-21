package com.app.threading;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MultiThreadedApplication {

	static int length = 59;

	public static void main(String[] args) throws IOException, InterruptedException {
		multiThreaded();
	}

	private static void multiThreaded() throws InterruptedException {
		long startTime = System.currentTimeMillis();
		Thread[] threads = new Thread[length];
		for (int i = 0; i < length; i++) {
			Runnable adder = new ThreadedAdder("inFiles/input" + i+".txt", "outFiles/output" + i+".txt");
			threads[i] = new Thread(adder);
			threads[i].start();
		}
		
		// Wait for other threads
		/**
		for (Thread thread : threads) {
			thread.join();
		}
		 */
		
		long timeElapsed = System.currentTimeMillis() - startTime;

		System.out.println("Elapsed Time = " + timeElapsed);
	}

}
