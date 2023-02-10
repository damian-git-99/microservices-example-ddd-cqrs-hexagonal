package com.microservices.example.notification.domain.valueobjects;

public class Subject {
    private String subject;

    public Subject(String subject) {
        this.subject = subject;
    }

    public String getValue() {
        return subject;
    }
}
