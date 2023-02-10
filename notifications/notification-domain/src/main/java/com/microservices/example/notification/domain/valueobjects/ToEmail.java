package com.microservices.example.notification.domain.valueobjects;

public class ToEmail {
    private String toEmail;

    public ToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getValue() {
        return toEmail;
    }
}
