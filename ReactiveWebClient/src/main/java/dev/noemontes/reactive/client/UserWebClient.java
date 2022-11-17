package dev.noemontes.reactive.client;

import org.springframework.web.reactive.function.client.WebClient;

import dev.noemontes.reactive.client.dto.UserDto;
import reactor.core.publisher.Mono;

public class UserWebClient {
	WebClient client = WebClient.create("http://localhost:8080");
	
	public void consumer() {
		Mono<UserDto> userMono = client.get()
									.uri("/user/{id}", 1)
									.retrieve()
									.bodyToMono(UserDto.class);
		
		userMono.subscribe(user -> System.out.println("User: " + user));
	}
}
