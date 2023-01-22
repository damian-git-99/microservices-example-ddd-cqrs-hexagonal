package com.microservices.example.user.domain;

public class UserName {
    private String username;

    public UserName(String username) {
        this.username = username;
    }

    public String getValue() {
        return username;
    }
}
