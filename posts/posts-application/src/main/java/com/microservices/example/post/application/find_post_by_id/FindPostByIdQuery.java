package com.microservices.example.post.application.find_post_by_id;

import com.microservices.example.common.domain.query.Query;

import java.util.UUID;

public class FindPostByIdQuery extends Query {
    private UUID postId;

    public FindPostByIdQuery(UUID postId) {
        this.postId = postId;
    }

    public UUID getPostId() {
        return postId;
    }
}
