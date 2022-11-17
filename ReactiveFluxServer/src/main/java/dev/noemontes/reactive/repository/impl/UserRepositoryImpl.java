package dev.noemontes.reactive.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dev.noemontes.reactive.dto.UserDto;
import dev.noemontes.reactive.repository.UserRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	private static final Map<String, UserDto> USER_DATA;
	
	static {
		USER_DATA = new HashMap<String, UserDto>();
		USER_DATA.put("1", new UserDto("1", "Nombre 1", "Apellido 1"));
		USER_DATA.put("2", new UserDto("2", "Nombre 2", "Apellido 2"));
		USER_DATA.put("3", new UserDto("3", "Nombre 3", "Apellido 3"));
		USER_DATA.put("4", new UserDto("4", "Nombre 4", "Apellido 4"));
		USER_DATA.put("5", new UserDto("5", "Nombre 5", "Apellido 5"));
		USER_DATA.put("6", new UserDto("6", "Nombre 6", "Apellido 6"));
		USER_DATA.put("7", new UserDto("7", "Nombre 7", "Apellido 7"));
		USER_DATA.put("8", new UserDto("8", "Nombre 8", "Apellido 8"));
		USER_DATA.put("9", new UserDto("9", "Nombre 9", "Apellido 9"));
		USER_DATA.put("10", new UserDto("10", "Nombre 10", "Apellido 10"));
	}
	

	@Override
	public Mono<UserDto> findUserById(String id) {
		return Mono.just(USER_DATA.get(id));
	}

	@Override
	public Flux<UserDto> findAllUsers() {
		return Flux.fromIterable(USER_DATA.values());
	}

	@Override
	public Mono<UserDto> updateUser(UserDto user) {
		UserDto existingUser =  USER_DATA.get(user.getId());
		
		if(existingUser != null) {
			existingUser.setName(user.getName());
			existingUser.setLastName(user.getLastName());
		}
		
		return Mono.just(existingUser);
	}
}
