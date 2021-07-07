package com.reactive.springwebfluxfunctional;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactive.springwebfluxfunctional.handler.ProductHandler;
import com.reactive.springwebfluxfunctional.model.Product;
import com.reactive.springwebfluxfunctional.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.TEXT_EVENT_STREAM;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;

@SpringBootApplication
public class SpringWebfluxFunctionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxFunctionalApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ReactiveMongoOperations reactiveMongoOperations, ProductRepository productRepository) {
		return args -> {
			Flux<Product> productFlux = Flux.just(new Product(null, "Processor", 12990.00),
					new Product(null, "Motherboard", 8370.00), new Product(null, "Solid State Drive", 5450.00))
					.flatMap(productRepository::save);

			productFlux.thenMany(productRepository.findAll()).subscribe(System.out::println);

			/**
			 * reactiveMongoOperations.collectionExists(Product.class) .flatMap(exists ->
			 * exists? reactiveMongoOperations.dropCollection(Product.class) :
			 * Mono.just(exists)) .thenMany(v ->
			 * reactiveMongoOperations.createCollection(Product.class))
			 * .thenMany(productFlux) .thenMany(productRepository.findAll())
			 * .subscribe(System.out::println);
			 */
		};

	}

	@Bean
	RouterFunction<ServerResponse> routes(ProductHandler handler) {

		/**
		return route(GET("/products").and(accept(APPLICATION_JSON)), handler::getAllProducts)
				.andRoute(POST("/products").and(contentType(APPLICATION_JSON)), handler::saveProduct)
				.andRoute(DELETE("/products").and(contentType(APPLICATION_JSON)), handler::deleteAllProducts)
				.andRoute(GET("/products/events").and(contentType(APPLICATION_JSON)), handler::getProductEvents)
				.andRoute(GET("/products/{id}").and(contentType(APPLICATION_JSON)), handler::getProduct)
				.andRoute(PUT("/products/{id}").and(contentType(APPLICATION_JSON)), handler::updateProduct)
				.andRoute(DELETE("/products/{id}").and(contentType(APPLICATION_JSON)), handler::deleteProduct);
			*/
		
		return nest(path("/products"),
				/*nest(accept(APPLICATION_JSON).or(contentType(APPLICATION_JSON)).or(accept(TEXT_EVENT_STREAM)),*/
					route(GET("/"), handler::getAllProducts)
					.andRoute(POST("/"), handler::saveProduct)
					.andRoute(DELETE("/"), handler::deleteAllProducts)
					.andRoute(GET("/events"), handler::getProductEvents)
					.andNest(path("/{id}"),
						route(GET(""), handler::getProduct)
						.andRoute(PUT(""), handler::updateProduct)
						.andRoute(DELETE(""), handler::deleteProduct)
						));
	}

}
