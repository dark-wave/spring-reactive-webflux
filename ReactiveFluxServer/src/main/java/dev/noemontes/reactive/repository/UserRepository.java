package dev.noemontes.reactive.repository;

import dev.noemontes.reactive.dto.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {
	public Mono<UserDto> findUserById(String id);
	public Mono<UserDto> updateUser(UserDto user);
	public Flux<UserDto> findAllUsers();
}
