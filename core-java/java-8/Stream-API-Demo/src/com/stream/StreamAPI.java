package com.stream;

import java.util.Arrays;
import java.util.List;

public class StreamAPI {

	private static StreamAPI api = new StreamAPI();

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(new Person("1", "Santanu", "Kolkata", 31),
				new Person("2", "Bhattacharyya", "Mumbai", 28), new Person("3", "Ratul", "Bangalore", 30),
				new Person("4", "Ratulb", "Serampore", 29), new Person("5", "BhattacharyyaS", "Delhi", 35));

		// Print All Elements
		// api.printAllElements(people);
		
		api.filterListByAttribute(people);
		
		
		java.util.function.BiPredicate<T, U>

	}

	private void printAllElements(List<Person> people) {
		System.out.println("-----printAllElements-----");
		// people.forEach(System.out::println);
		// people.stream().forEach(p -> System.out.println(p));
		
		people.stream().forEach(System.out::println);
	}

	private void filterListByAttribute(List<Person> people) {
		System.out.println("-----filterListByAttribute-----");
		people.stream().
		filter((p) -> p.getPersonAge() >= 30)
		.forEach(p -> System.out.println(p.getPersonName()+" : "+p.getPersonAge()));
	}

}
