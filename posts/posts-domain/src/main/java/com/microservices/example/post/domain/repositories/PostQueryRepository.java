package com.microservices.example.post.domain.repositories;

import com.microservices.example.common.domain.valueobjects.UserId;
import com.microservices.example.post.domain.valueobjects.PostId;
import com.microservices.example.post.domain.entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostQueryRepository {
    List<Post> findPostsByUser(UserId userId);
    Optional<Post> findPostById(PostId id);
}
