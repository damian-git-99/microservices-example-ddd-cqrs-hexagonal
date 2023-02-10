package com.microservices.example.post.domain.repositories;

import com.microservices.example.post.domain.entities.Post;

public interface PostCommandRepository {
    void createPost(Post post);
    void deletePost(Post post);
}
