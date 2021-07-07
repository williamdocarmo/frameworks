package com.reactive.springwebfluxfunctional.handler;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactive.springwebfluxfunctional.model.Product;
import com.reactive.springwebfluxfunctional.model.ProductEvent;
import com.reactive.springwebfluxfunctional.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProductHandler {

	@Autowired
	private ProductRepository productRepository;

	public Mono<ServerResponse> getAllProducts(ServerRequest request) {
		System.out.println("Invoked: getAllProducts");
		Flux<Product> products = productRepository.findAll();
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(products, Product.class);
	}

	public Mono<ServerResponse> getProduct(ServerRequest request) {
		System.out.println("Invoked: getProduct");
		String id = request.pathVariable("id");
		Mono<Product> productMono = productRepository.findById(id);
		return productMono.flatMap(product -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromObject(product))).switchIfEmpty(ServerResponse.notFound().build());
	}

	public Mono<ServerResponse> saveProduct(ServerRequest request) {
		System.out.println("Invoked: saveProduct");
		Mono<Product> productMono = request.bodyToMono(Product.class);
		return productMono.flatMap(product -> ServerResponse.status(HttpStatus.CREATED)
				.contentType(MediaType.APPLICATION_JSON).body(productRepository.save(product), Product.class));
	}

	public Mono<ServerResponse> updateProduct(ServerRequest request) {
		System.out.println("Invoked: updateProduct");
		String id = request.pathVariable("id");
		Mono<Product> existingProductMono = this.productRepository.findById(id);
		Mono<Product> productMono = request.bodyToMono(Product.class);

		Mono<ServerResponse> notFound = ServerResponse.notFound().build();

		return productMono
				.zipWith(existingProductMono,
						(product, existingProduct) -> new Product(existingProduct.getId(), product.getName(),
								product.getPrice()))
				.flatMap(product -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
						.body(productRepository.save(product), Product.class))
				.switchIfEmpty(notFound);
	}

	public Mono<ServerResponse> deleteProduct(ServerRequest request) {
		System.out.println("Invoked: deleteProduct");
		String id = request.pathVariable("id");

		Mono<Product> productMono = this.productRepository.findById(id);
		Mono<ServerResponse> notFound = ServerResponse.notFound().build();

		return productMono
				.flatMap(existingProduct -> ServerResponse.ok().build(productRepository.delete(existingProduct)))
				.switchIfEmpty(notFound);
	}

	public Mono<ServerResponse> deleteAllProducts(ServerRequest request) {
		System.out.println("Invoked: deleteAllProducts");
		return ServerResponse.ok().build(productRepository.deleteAll());
	}

	public Mono<ServerResponse> getProductEvents(ServerRequest request) {
		System.out.println("Invoked: getProductEvents");
		Flux<ProductEvent> eventsFlux = Flux.interval(Duration.ofSeconds(1))
				.map(val -> new ProductEvent(val, "Product Event"));

		return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(eventsFlux, ProductEvent.class);
	}

}
