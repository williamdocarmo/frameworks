package com.app;

public class Launcher {
	
	static ORMApplication application = new ORMApplication();
	
	public static void main(String[] args) throws InterruptedException {
		
		// insertSimpleKey();
		
		// insertUuidKey(); 
		
		// insertTableBasedKey();
		
		// insertSequenceBasedKey();
		
		// application.insertCustomKey();
		
		// application.insertDataWithValueObject();
		
		// application.insertDataWithMultipleValueObject();
		
		// application.insertComplexKey();
		
		// application.insertDataWithListObject();
		
		application.getDataWithListObject();
		
		// application.insertDataWithMapObject();
		
	}

}