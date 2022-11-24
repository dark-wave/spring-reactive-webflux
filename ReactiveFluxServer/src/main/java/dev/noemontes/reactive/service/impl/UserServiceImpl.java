package dev.noemontes.reactive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.noemontes.reactive.entity.UserEntity;
import dev.noemontes.reactive.repository.UserRepository;
import dev.noemontes.reactive.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<UserEntity> getAllUser() {
		return (List<UserEntity>) userRepository.findAll();
	}

	@Override
	@Transactional
	public UserEntity saveUser(UserEntity user) {
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}
}
