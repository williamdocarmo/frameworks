package com.app;

public class Launcher {
	
	static ORMApplication application = new ORMApplication();

	public static void main(String[] args) throws InterruptedException {

		// save, saveOrUpdate, persist
		application.insert(); 
		
		// get, load, find
		// application.select();
		
		// saveOrUpdate, update, merge
		application.update();
		
		// delete, remove
		// application.delete();
	}

	

	
	
}
