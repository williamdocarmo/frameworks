package com.algorithm.utils;

public class Util {

	public static String printArray(Object[] array) {
		String arrayString = "";
		for (Object obj : array)
			arrayString += obj + ", ";
		if(arrayString.endsWith(", "))
			arrayString = arrayString.substring(0, arrayString.length()-2);
		return arrayString;
	}

}
