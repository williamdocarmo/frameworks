package webclient.client;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import webclient.model.Product;
import webclient.model.ProductEvent;

public class WebClientAPI {

	private WebClient webclient;

	WebClientAPI() {
		this.webclient = WebClient.builder().baseUrl("http://localhost:8080/products/")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}
	
	public static void main(String[] args) {
		WebClientAPI api = new WebClientAPI();
		api.addProduct()
			.thenMany(api.getAllProducts())
			.take(1)
			.flatMap(p -> api.updateProduct(p.getId(), "Cabinet", 1999.99))
			.flatMap(p -> api.deleteProduct(p.getId()))
			.thenMany(api.getAllProducts())
			.thenMany(api.getAllEvents())
			.subscribe(System.out::println);
	}
	
	private Mono<ResponseEntity<Product>> addProduct(){
		return webclient.post()
				.uri("/")
				.body(Mono.just(new Product(null, "Graphics Card", 9999.00)), Product.class)
				.exchange()
				.flatMap(response -> response.toEntity(Product.class))
				.doOnSuccess(o -> System.out.println("*******POST RESPONSE "+o))
				;
	}
	
	private Flux<Product> getAllProducts(){
		Flux<Product> flux = webclient.get()
				.uri("/")
				.retrieve()
				.bodyToFlux(Product.class)
				.doOnNext(o -> System.out.println("*******GET RESPONSE "+o));
		return flux
				;
	}
	
	private Mono<Product> updateProduct(String id, String name, double price){
		return webclient.put()
				.uri("/{id}", id)
				.body(Mono.just(new Product(null, name, price)), Product.class)
				.retrieve()
				.bodyToMono(Product.class)
				.doOnSuccess(o -> System.out.println("*******PUT RESPONSE "+o))
				;
	}
	
	private Mono<Void> deleteProduct(String id){
		return webclient.put()
				.uri("/{id}", id)
				.retrieve()
				.bodyToMono(Void.class)
				.doOnSuccess(o -> System.out.println("*******DELETE RESPONSE "+o))
				;
	}
	
	private Flux<ProductEvent> getAllEvents(){
		return webclient.get()
				.uri("/events")
				.retrieve()
				.bodyToFlux(ProductEvent.class)
				;
	}

}
