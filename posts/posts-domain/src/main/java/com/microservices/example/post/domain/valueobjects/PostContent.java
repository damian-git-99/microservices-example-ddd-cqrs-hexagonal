package com.microservices.example.post.domain.valueobjects;

public class PostContent {
    private String value;

    public PostContent(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
