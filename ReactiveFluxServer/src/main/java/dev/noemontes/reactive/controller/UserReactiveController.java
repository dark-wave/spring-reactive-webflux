package dev.noemontes.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.noemontes.reactive.dto.UserDto;
import dev.noemontes.reactive.repository.UserRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserReactiveController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public Flux<UserDto> getAllUsers(){
		return userRepository.findAllUsers();
	}
	
	@GetMapping("/{id}")
	public Mono<UserDto> getUserById(@PathVariable String id){
		return userRepository.findUserById(id);
	}
	
	@PostMapping("/update")
	public Mono<UserDto> updateUser(@RequestBody UserDto user){
		return userRepository.updateUser(user);
	}
}
