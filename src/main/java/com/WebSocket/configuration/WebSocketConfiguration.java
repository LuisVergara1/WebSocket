package com.WebSocket.configuration;

import org.springframework. context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer{

    @Override
    public void configureMessageBroker(@SuppressWarnings("null") MessageBrokerRegistry registry) {
     registry.enableSimpleBroker("/topic");
     registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(@SuppressWarnings("null") StompEndpointRegistry registry) {
      registry.addEndpoint("/chat-socket")
      .setAllowedOrigins("http://163.132.47.63:4200","http:chat.luisvergara.dev")
      .withSockJS();
    }

   
}
