package com.microservices.example.post.application.delete_post;

import com.microservices.example.post.domain.entities.Post;
import com.microservices.example.post.domain.repositories.PostCommandRepository;
import org.springframework.stereotype.Service;

@Service
public class PostDeleter {

    private final PostCommandRepository repository;

    public PostDeleter(PostCommandRepository repository) {
        this.repository = repository;
    }

    public void deletePost(Post post) {
        repository.deletePost(post);
    }

}
