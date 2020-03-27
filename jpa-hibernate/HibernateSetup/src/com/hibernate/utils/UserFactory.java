package com.hibernate.utils;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.hibernate.model.UserDataVO;

public class UserFactory {

	public static UserDataVO getUser() {
		int id = generateId();
		Date dob = generateDob();
		UserDataVO user = new UserDataVO();
		user.setUsername("user" + id);
		user.setFirstname("FirstName" + id);
		user.setLastname("LastName" + id);
		user.setDateOfBirth(dob);
		user.setAge(2018 - dob.getYear());
		user.setBiography(generateBio());
		user.setOldUser((id % 2 == 0 ? true : false));
		return user;
	}

	private static int generateId() {
		return new Random().nextInt(10000);
	}

	private static Date generateDob() {
		Date date = new Date();
		date.setDate(ThreadLocalRandom.current().nextInt(1, 28));
		date.setMonth(ThreadLocalRandom.current().nextInt(1, 12));
		date.setYear(ThreadLocalRandom.current().nextInt(1965, 1989));
		return date;
	}

	private static String generateBio() {
		int length = ThreadLocalRandom.current().nextInt(155, 524 + 1);
		String bio = "";
		for (int i = 0; i < length; i++) {
			int asciiInt = ThreadLocalRandom.current().nextInt(65, 91);
			bio += Character.toString((char) asciiInt);
		}
		return bio;
	}
	
}
