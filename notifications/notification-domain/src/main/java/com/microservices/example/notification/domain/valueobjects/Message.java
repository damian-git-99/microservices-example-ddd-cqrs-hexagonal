package com.microservices.example.notification.domain.valueobjects;

public class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }
}
