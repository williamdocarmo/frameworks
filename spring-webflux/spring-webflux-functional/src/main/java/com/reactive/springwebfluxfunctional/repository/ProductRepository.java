package com.reactive.springwebfluxfunctional.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.reactive.springwebfluxfunctional.model.Product;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

}
