package dev.noemontes.reactive.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import dev.noemontes.reactive.entity.UserEntity;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveCrudRepository<UserEntity, Long>{
	
	@Query("select id, name, lastname from users where name = $1")
	Flux<UserEntity> findAllByName(String name);
	
	@Query("select id, name, lastname from users where name = $1")
	Flux<UserEntity> findByLastname(String lastName);
}
