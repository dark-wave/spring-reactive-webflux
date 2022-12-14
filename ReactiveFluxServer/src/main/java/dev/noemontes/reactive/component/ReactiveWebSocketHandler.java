package dev.noemontes.reactive.component;

import static java.time.LocalDateTime.now;
import static java.util.UUID.randomUUID;

import java.time.Duration;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.noemontes.reactive.dto.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component("ReactiveWebSocketHandler")
public class ReactiveWebSocketHandler implements WebSocketHandler{

	private static final ObjectMapper json = new ObjectMapper();

	private Flux<String> eventFlux = Flux.generate(sink -> {
		Message event = new Message(randomUUID().toString(), now().toString());
		
		try {
			sink.next(json.writeValueAsString(event));
		} catch (JsonProcessingException e) {
			sink.error(e);
		}
	});
	
	private Flux<String> intervalFlux = Flux.interval(Duration.ofMillis(1000L))
											.zipWith(eventFlux, (time, event) -> event);	
	
	@Override
	public Mono<Void> handle(WebSocketSession webSocketSession) {
		return webSocketSession.send(intervalFlux.map(webSocketSession::textMessage))
								.and(webSocketSession.receive().map(WebSocketMessage::getPayloadAsText).log());
	}
}
