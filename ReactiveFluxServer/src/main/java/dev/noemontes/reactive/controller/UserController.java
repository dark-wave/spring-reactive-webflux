package dev.noemontes.reactive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.noemontes.reactive.entity.UserEntity;
import dev.noemontes.reactive.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody UserEntity user){
		UserEntity userSaved = userService.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllUsers(){
		List<UserEntity> userList = userService.getAllUser();
		
		if(userList.size()>0) {
			return ResponseEntity.ok(userList);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping
	public ResponseEntity<?> deteleAllUsers(){
		userService.deleteAllUsers();
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
