package com.app.test;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class OperatorTest {

	// @Test
	void map() {
		Flux.range(1, 5)
			.map(i -> i*5)
			.log()
			.subscribe(System.out::println);
	}
	
	// @Test
	void flatMap() {
		Flux.range(1, 5)
			.flatMap(i -> Flux.range(i*10, 2))
			.log()
			.subscribe(System.out::println);
	}
	
	// @Test
	void flatMapMany() {
		Mono.just(3)
			.flatMapMany(i -> Flux.range(1, i))
			.subscribe(System.out::println);
	}
	
	// @Test
	void concat() throws InterruptedException {
		Flux<Integer> oneToFive = Flux.range(1, 5).delayElements(Duration.ofMillis(500));
		Flux<Integer> sixToTen = Flux.range(6, 5).delayElements(Duration.ofMillis(1000));
		Flux.concat(oneToFive, sixToTen).log().subscribe(System.out::println);
		Thread.sleep(10000);
	}
	
	// @Test
	void merge() throws InterruptedException {
		Flux<Integer> oneToFive = Flux.range(1, 5).delayElements(Duration.ofMillis(500));
		Flux<Integer> sixToTen = Flux.range(6, 5).delayElements(Duration.ofMillis(1000));
		Flux.merge(oneToFive, sixToTen).log().subscribe(System.out::println);
		Thread.sleep(10000);
	}
	
	@Test
	void zip() throws InterruptedException {
		Flux<Integer> oneToFive = Flux.range(1, 5);
		Flux<Integer> sixToTen = Flux.range(6, 5);
		Flux.merge(oneToFive, sixToTen).log().subscribe(System.out::println);
		Flux.zip(oneToFive, sixToTen, (x, y) -> x + "," + y).subscribe(System.out::println);
		Thread.sleep(10000);
	}
	
	


}
