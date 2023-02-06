package com.microservices.example.common.domain.valueobjects;

import java.util.UUID;

public class UserId {
    private UUID userId;

    public UserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getValue() {
        return userId;
    }
}
