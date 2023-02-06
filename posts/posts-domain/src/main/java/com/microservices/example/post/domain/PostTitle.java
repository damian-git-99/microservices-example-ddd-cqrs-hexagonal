package com.microservices.example.post.domain;

public class PostTitle {
    private String value;

    public PostTitle(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
