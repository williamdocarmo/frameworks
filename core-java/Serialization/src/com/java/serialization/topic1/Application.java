package com.java.serialization.topic1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Application {

	private static final String FILENAME = "file.dat";

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//serialize();
		deserialize();
	}

	private static void serialize() throws IOException {
		FileOutputStream fos = new FileOutputStream(FILENAME);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(Util.createModel());
		oos.close();
	}

	private static void deserialize() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(FILENAME);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object object = ois.readObject();
		System.out.println(object.getClass());
		Model instance = (Model) object;
		ois.close();
		System.out.println("Instance: " + instance);
	}

}
