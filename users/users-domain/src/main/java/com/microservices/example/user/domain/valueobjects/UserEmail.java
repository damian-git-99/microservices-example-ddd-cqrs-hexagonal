package com.microservices.example.user.domain.valueobjects;

public class UserEmail {
    private String email;

    public UserEmail(String email) {
        this.email = email;
    }

    public String getValue() {
        return email;
    }
}
