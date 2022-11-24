package dev.noemontes.reactive.service;

import java.util.List;

import dev.noemontes.reactive.entity.UserEntity;

public interface UserService {
	public List<UserEntity> getAllUser();
	public UserEntity saveUser(UserEntity user);
	public void deleteAllUsers();
}
