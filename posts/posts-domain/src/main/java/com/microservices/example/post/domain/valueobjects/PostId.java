package com.microservices.example.post.domain.valueobjects;

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
