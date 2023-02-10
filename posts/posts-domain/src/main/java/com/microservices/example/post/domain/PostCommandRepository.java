package com.microservices.example.post.domain;

public interface PostCommandRepository {
    void createPost(Post post);
    void deletePost(Post post);
}
