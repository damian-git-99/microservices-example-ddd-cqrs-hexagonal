package com.microservices.example.notification.domain;

public class ToEmail {
    private String toEmail;

    public ToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getToEmail() {
        return toEmail;
    }
}
