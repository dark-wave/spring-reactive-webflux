package dev.noemontes.reactive.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import dev.noemontes.reactive.entity.UserEntity;

@Component
@RepositoryEventHandler
public class UserEventListener {
	private static final Logger LOG = LoggerFactory.getLogger(UserEventListener.class); 
	
	@HandleBeforeCreate
	public void handleUserBeforeCreate(UserEntity user){
		System.out.println("*** ANTES DE CREAR ***");
		LOG.debug("Evento lanzado antes de crear el usuario");
		LOG.debug(user.toString());
	}
	
	@HandleAfterCreate
	public void handleUserAfterCreate(UserEntity user) {
		System.out.println("*** DESPUES DE CREAR ***");
		LOG.debug("Evento lanzado despues de crear el usuario");
		LOG.debug(user.toString());
	}
	
	@HandleBeforeSave
	public void handleUserBeforeSave(UserEntity user) {
		System.out.println("*** ANTES DE GUARDAR ***");
		LOG.debug("Evento lanzado antes de guardar el usuario");
		LOG.debug(user.toString());
	}
	
	
	@HandleAfterSave
	public void handleUserAfterSave(UserEntity user) {
		System.out.println("*** DESPUES DE GUARDAR ***");
		LOG.debug("Evento lanzado despues de guardar el usuario");
		LOG.debug(user.toString());
	}
}
