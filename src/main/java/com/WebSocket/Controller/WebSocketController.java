package com.WebSocket.Controller;


import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.WebSocket.Models.ChatMessage;

@Controller
public class WebSocketController {

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public ChatMessage chat(@DestinationVariable String roomId,ChatMessage message)
    {
        System.out.println(message);
        return new ChatMessage(message.getMessage(), message.getUser());
    }
    
}
