package com.hibernate.app;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Dummy {

	public static void main(String[] args) {
		URL s = Dummy.class.getResource("hibernate.cfg.xml");
		System.out.println(s);
	}

}
