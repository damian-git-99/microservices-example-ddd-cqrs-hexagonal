package com.microservices.example.user.application.find_user;

import com.microservices.example.common.domain.query.Query;

import java.util.UUID;

public class FindUserQuery extends Query {
    private UUID userId;

    public FindUserQuery(UUID userId) {
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }
}
