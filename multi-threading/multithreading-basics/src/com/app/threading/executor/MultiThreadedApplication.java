package com.app.threading.executor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadedApplication {

	static int length = 59;

	public static void main(String[] args) throws IOException, InterruptedException {
		multiThreaded();
	}

	private static void multiThreaded() throws InterruptedException {
		long startTime = System.currentTimeMillis();

		ExecutorService es = Executors.newFixedThreadPool(10);
		for (int i = 0; i < length; i++) {
			ThreadedAdder adder = new ThreadedAdder("inFiles/input" + i + ".txt", "outFiles/output" + i + ".txt");
			es.submit(adder);
		}
		es.shutdown();
		//es.awaitTermination(0, TimeUnit.SECONDS);

		long timeElapsed = System.currentTimeMillis() - startTime;

		System.out.println("Elapsed Time = " + timeElapsed);
	}

}
