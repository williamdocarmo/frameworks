package com.app;

public class Launcher {
	
	static ORMApplication application = new ORMApplication();
	
	public static void main(String[] args) throws InterruptedException {
		
		application.persistVehicle();
		
	}

}