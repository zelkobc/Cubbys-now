package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.revature.Handlers.PostWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {

	private final static String POST_ENDPOINT = "/postaction";
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(getPostWebSocketHandler(), POST_ENDPOINT).setAllowedOrigins("http://localhost:4200");
	}

	@Bean
	public WebSocketHandler getPostWebSocketHandler() {
		return new PostWebSocketHandler();
	}
	
}
