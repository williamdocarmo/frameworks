package com.reactive.springwebflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.reactive.springwebflux.model.Product;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

	// Flux<Product> findByName(Publisher<String> name);

}
