package com.app.test;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Mono;

public class MonoTest {

	@Test
	void firstMono() {
		System.out.println("---------------------------------FirstMono---------------------------------");
		Mono.just("A").log().subscribe();
	}
	
	@Test
	void monoWithConsumer() {
		System.out.println("---------------------------------MonoWithConsumer---------------------------------");
		Mono.just("A")
			.log()
			.subscribe(System.out::println);
	}

	@Test
	void monoWithDo() {
		System.out.println("---------------------------------MonoWithDo---------------------------------");
		Mono.just("A")
			.log()
			.doOnSubscribe(s -> System.out.println("Subscribed: " + s))
			.doOnRequest(s -> System.out.println("Request: " + s))
			.doOnSuccess(s -> System.out.println("Complete: " + s))
			.subscribe(System.out::println);
	}
	
	@Test
	void emptyMono() {
		System.out.println("---------------------------------EmptyMono---------------------------------");
		Mono.empty()
			.log()
			.subscribe(System.out::println, null, () -> System.out.println("Done!"));
		;
	}

	
	@Test
	void runtimeExceptionMono() {
		System.out.println("---------------------------------Runtime Exception---------------------------------");
		Mono.error(new RuntimeException())
			.log()
			.subscribe();
	}
	
	@Test
	void checkedExceptionMono() {
		System.out.println("---------------------------------Exception---------------------------------");
		Mono.error(new Exception("Throwing Error!"))
			.log()
			.doOnError(e -> System.out.println("Error: "+e.getMessage()))
			.subscribe();
	}
	
	@Test
	void errorResume() {
		System.out.println("---------------------------------Error Resume---------------------------------");
		Mono.error(new Exception("Throwing Error!"))
			.onErrorResume(e -> {
				System.out.println("Caught: "+e);
				return Mono.just("B");
				
			})
			.log()
			.subscribe();
	}
	
	@Test
	void errorReturn() {
		System.out.println("---------------------------------Error Resume---------------------------------");
		Mono.error(new Exception("Throwing Error!"))
			.onErrorReturn("B")
			.log()
			.subscribe();
	}
}
