package com.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StreamAPI {

	private static StreamAPI api = new StreamAPI();

	public static void main(String[] args) {
		// api.map();
		api.filterMapByAttribute();
	}

	private void map() {

		List<Integer> list = Arrays.asList(1, 3, 6, 7, 9, 12);
		// System.out.println(list.stream().map(i -> i * 2).reduce(0, (c, e) -> c + e));

		// addAllElementsAfterMultiplyingBy5();

		// addAllElementsDivisibleBy5();

		// System.out.println(list.stream().reduce(0, (c, e) -> c + e));
		
		
	// 	optionalDemo();
// 
	}
	
	private void filterMapByAttribute() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "One");
		map.put("2", "Two");
		map.put("3", "Three");
		map.put("_2", "Two");
		map.put("4", "Four");
		map.keySet().stream().filter((k) -> map.get(k).equals("Two")).forEach(System.out::println);
	}

	private void optionalDemo() {
		List<Integer> list1 = Arrays.asList(1, 3, 6, 7, 9, 12);
		Optional<Integer> result1 = list1.stream().filter(n -> n % 5 == 0).map(i -> i*2).reduce(Integer::sum);
		System.out.println(result1);
		if (result1.isPresent()) {
			System.out.println("Element Present in Result 1: "+result1.get());
		}
		
		List<Integer> list2 = Arrays.asList(7, 10, 15, 27, 5, 9, 11, 22, 45, 20);
		Optional<Integer> result2 = list2.stream().filter(n -> n % 5 == 0).map(i -> i*2).reduce(Integer::sum);
		System.out.println(result2);
		if (result2.isPresent()) {
			System.out.println("Element Present in Result 2: "+result2.get());
		}
		
		List<Integer> list3 = Arrays.asList(7, 10, 15, 27, 5, 9, 11, 22, 45, 20);
		Optional<Integer> result3 = Optional.ofNullable(list2.stream().filter(n -> n % 6 == 0).map(i -> i*2).findFirst().orElse(0));
		if (result3.isPresent()) {
			System.out.println("Element Present in Result 3: "+result3.get());
		}
	}

	// Print All Elements
	private void printAllElements() {
		List<Person> people = Arrays.asList(new Person("1", "Santanu", "Kolkata", 31),
				new Person("2", "Bhattacharyya", "Mumbai", 28), new Person("3", "Ratul", "Bangalore", 30),
				new Person("4", "Ratulb", "Serampore", 29), new Person("5", "BhattacharyyaS", "Delhi", 35));
		System.out.println("-----printAllElements-----");
		// people.forEach(System.out::println);
		// people.stream().forEach(p -> System.out.println(p));

		people.stream().forEach(System.out::println);
	}

	// Filter
	private void filterListByAttribute() {
		List<Person> people = Arrays.asList(new Person("1", "Santanu", "Kolkata", 31),
				new Person("2", "Bhattacharyya", "Mumbai", 28), new Person("3", "Ratul", "Bangalore", 30),
				new Person("4", "Ratulb", "Serampore", 29), new Person("5", "BhattacharyyaS", "Delhi", 35));
		System.out.println("-----filterListByAttribute-----");
		people.stream().filter((p) -> p.getPersonAge() >= 30)
				.forEach(p -> System.out.println(p.getPersonName() + " : " + p.getPersonAge()));
	}
	
	

	private void addAllElementsAfterMultiplyingBy5() {
		List<Integer> list = Arrays.asList(7, 10, 15, 27, 5, 9, 11, 22, 45, 20);
		System.out.println(list.stream().map(i -> i * 2).reduce(0, Integer::sum));
	}

	private void addAllElementsDivisibleBy5() {
		List<Integer> list = Arrays.asList(7, 10, 15, 27, 5, 9, 11, 22, 45, 20);

		System.out.println(list.stream().filter(n -> n % 5 == 0).reduce(Integer::sum).get());
	}
	
}
