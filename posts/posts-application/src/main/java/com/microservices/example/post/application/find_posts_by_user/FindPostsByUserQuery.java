package com.microservices.example.post.application.find_posts_by_user;

import com.microservices.example.common.domain.query.Query;

import java.util.UUID;

public class FindPostsByUserQuery extends Query {
    private UUID userId;

    public FindPostsByUserQuery(UUID userId) {
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }
}
