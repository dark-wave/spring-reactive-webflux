package dev.noemontes.reactive.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

@Configuration
public class ReactiveWebsocketConfiguration {
	
	@Autowired
	@Qualifier("ReactiveWebSocketHandler")
	private WebSocketHandler webSocketHandler;
	
	@Bean
	public HandlerMapping webSocketHandlerMapping() {
		Map<String, WebSocketHandler> map = new HashMap<String, WebSocketHandler>();
		map.put("/event-emiter", webSocketHandler);
		
		SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
		handlerMapping.setOrder(1);
		handlerMapping.setUrlMap(map);
		
		return handlerMapping;
	}
	
	@Bean
	public WebSocketHandlerAdapter handlerAdapter() {
		return new WebSocketHandlerAdapter();
	}
}
