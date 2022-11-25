package dev.noemontes.reactive.listener;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.noemontes.reactive.entity.UserEntity;

public class UserEventListener {
	private static final Logger LOG = LoggerFactory.getLogger(UserEventListener.class);
	
	@PrePersist
	@PreUpdate
	@PreRemove
	private void eventBeforeUpdateDB(UserEntity user) {
		LOG.debug("Evento de actualización en base de datos: " + user.toString());
	}
}
