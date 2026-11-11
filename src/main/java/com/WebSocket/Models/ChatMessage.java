package com.WebSocket.Models;

import lombok.Data;

@Data
public class ChatMessage {
    private String message;
    private String user;
    private String displayName;
}
