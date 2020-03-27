package com.java.serialization.topic1;

public class Util {
	
	public static Model createModel() {
		String param1 = "value1";
		int param2 = 1;
		int[] param3 = { 0, 1, 2, 3, 4, 5 };
		String password = "hiddenparam";
		Model model = new Model(param1, param2, param3, password);
		return model;
	}

}
