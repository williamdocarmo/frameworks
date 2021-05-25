package com.reactive.springwebflux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;

import com.reactive.springwebflux.model.Product;
import com.reactive.springwebflux.repository.ProductRepository;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringWebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init (ReactiveMongoOperations operations, ProductRepository repository) {
		return args -> {
			Flux<Product> productFlux = Flux.just(
					new Product("p1", "Processor", 15650.00),
					new Product("p2", "Motherboard", 12630.50),
					new Product("p3", "Graphics Card", 19990.00))
					.flatMap(repository::save);
			
			productFlux.thenMany(repository.findAll())
						.log()
						.subscribe(System.out::println);

		};
	}

}
