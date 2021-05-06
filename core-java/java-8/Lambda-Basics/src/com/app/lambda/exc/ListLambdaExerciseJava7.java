package com.app.lambda.exc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListLambdaExerciseJava7 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("1", "Santanu", "Kolkata", 31),
				new Person("2", "Bhattacharyya", "Mumbai", 28), new Person("3", "Ratul", "Bangalore", 30),
				new Person("4", "Ratulb", "Serampore", 29), new Person("5", "BhattacharyyaS", "Delhi", 35));

		// Sort by address
		Collections.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getPersonAddress().compareTo(o2.getPersonAddress());
			}
		});
		// Print all elements
		printAllPeople(people);

		// Print all people name starting with R
		printConditionally(people, new Condition() {

			@Override
			public boolean match(Person p) {
				return p.getPersonName().startsWith("R");
			}
		});

	}

	private static void printConditionally(List<Person> people, Condition c) {
		for (Person p : people) {
			if (c.match(p)) {
				System.out.println("Name Starting with R: " + p);
			}
		}
	}

	private static void printAllPeople(List<Person> people) {
		for (Person p : people) {
			System.out.println("Sorted People: " + p);
		}
	}

}
