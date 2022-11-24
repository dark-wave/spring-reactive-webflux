package dev.noemontes.reactive.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import dev.noemontes.reactive.entity.UserEntity;

@Configuration
public class RestConfiguration implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration repositoryConfig, CorsRegistry cors) {
		repositoryConfig.getProjectionConfiguration().addProjection(UserEntity.class);
	}
}
