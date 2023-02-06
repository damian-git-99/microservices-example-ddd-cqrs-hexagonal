package com.microservices.example.post.domain;

import java.util.UUID;

public class PostId {
    private UUID id;

    public PostId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
