package com.microservices.example.post.domain;

import java.util.UUID;

public class PostId {
    private UUID value;

    public PostId(UUID value) {
        this.value = value;
    }

    public UUID getValue() {
        return value;
    }
}
