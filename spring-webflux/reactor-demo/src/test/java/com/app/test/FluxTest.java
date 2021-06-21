package com.app.test;

import java.time.Duration;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class FluxTest {

	// @Test
	void firstFlux() {
		Flux.just("A", "B", "C")
			.log()
			.subscribe();
	}

	// @Test
	void fluxFromIterable() {
		Flux.fromIterable(Arrays.asList("A", "B", "C"))
			.log()
			.subscribe();
	}
	
	// @Test
	void fluxFromRange() {
		Flux.range(5, 3)
			.log()
			.subscribe();
	}
	
	// @Test
	void fluxFromInterval() throws InterruptedException {
		Flux.interval(Duration.ofSeconds(1))
			.log()
			.take(2)
			.subscribe();
		Thread.sleep(5000);
	}
	
	@Test
	void fluxRequest() throws InterruptedException {
		Flux.range(1, 5)
			.log()
			.subscribe(null, null, null, s -> s.request(3));
	}

}
