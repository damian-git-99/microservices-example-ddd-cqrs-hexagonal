package com.microservices.example.post.domain;

import com.microservices.example.common.domain.valueobjects.UserId;

import java.util.List;
import java.util.Optional;

public interface PostQueryRepository {
    List<Post> findPostsByUser(UserId userId);
    Optional<Post> findPostById(PostId id);
}
