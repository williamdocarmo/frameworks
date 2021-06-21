package com.app.threading;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SingleThreadedApplication {
	
	static int length = 59;

	public static void main(String[] args) throws IOException, InterruptedException {
		singleThreaded();
	}

	private static void singleThreaded() throws IOException {

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < length; i++) {
			Adder adder = new Adder("inFiles/input" + i+".txt", "outFiles/output" + i+".txt");
			adder.doAdd();
		}
		long timeElapsed = System.currentTimeMillis() - startTime;
		System.out.println("Elapsed Time = " + timeElapsed);
	}

}
