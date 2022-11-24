package dev.noemontes.reactive.repository;

import org.springframework.data.repository.CrudRepository;

import dev.noemontes.reactive.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{}
