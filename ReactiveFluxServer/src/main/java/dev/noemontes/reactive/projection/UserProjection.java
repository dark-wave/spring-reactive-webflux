package dev.noemontes.reactive.projection;

import org.springframework.data.rest.core.config.Projection;

import dev.noemontes.reactive.entity.UserEntity;

@Projection(name = "userProjection", types = {UserEntity.class})
public interface UserProjection {

}
