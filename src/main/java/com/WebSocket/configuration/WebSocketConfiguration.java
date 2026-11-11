package com.WebSocket.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer{

    @Value("${chat.allowed-origins}")
    private String[] allowedOrigins;

    @Override
    public void configureMessageBroker(@SuppressWarnings("null") MessageBrokerRegistry registry) {
     registry.enableSimpleBroker("/topic");
     registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(@SuppressWarnings("null") StompEndpointRegistry registry) {
      registry.addEndpoint("/chat-socket")
      .setAllowedOrigins(allowedOrigins)
      .withSockJS();
    }

   
}
