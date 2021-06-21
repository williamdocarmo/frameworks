package com.app.lambda.exc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class ListLambdaExerciseJava8 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("1", "Santanu", "Kolkata", 31),
				new Person("2", "Bhattacharyya", "Mumbai", 28), new Person("3", "Ratul", "Bangalore", 30),
				new Person("4", "Ratulb", "Serampore", 29), new Person("5", "BhattacharyyaS", "Delhi", 35));

		// Sort by address
		
		Collections.sort(people, (o1, o2) -> o1.getPersonAddress().compareTo(o2.getPersonAddress()));

		System.out.println("Print all Starting with R");
		printConditionally(people, p -> p.getPersonName().startsWith("R"));
		
		System.out.println("Print all with age < 30");
		printConditionally(people, p -> p.getPersonAge() < 30);
		
		System.out.println("Print all");
		printConditionally(people, p -> true);

	}

	private static void printConditionally(List<Person> people, Predicate<Person> predicate) {
		for (Person p : people) {
			if (predicate.test(p)) {
				System.out.println("Printed Conditionally: " + p);
			}
		}
	}

}
