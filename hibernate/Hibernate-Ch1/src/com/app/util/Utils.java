package com.app.util;

import java.util.Date;

public class Utils {
	
	public static Date firstJan() {
		Date date = new Date();
		date.setYear(new Date().getYear());
		date.setMonth(01);
		date.setDate(01);
		return date;
	}
	
	public static Date firstApril() {
		Date date = new Date();
		date.setYear(new Date().getYear());
		date.setMonth(03);
		date.setDate(01);
		return date;
	}

	public static String largeString() {
		String str = "";
		for (int i=0; i< 25; i++) {
			str += "Very Good Customer";
		}
		return str;
	}

}
