package com.microservices.example.post.application.create_post;

import com.microservices.example.common.domain.events.EventBus;
import com.microservices.example.post.domain.Post;
import com.microservices.example.post.domain.PostCommandRepository;
import org.springframework.stereotype.Service;

@Service
public class PostCreator {

    private final PostCommandRepository repository;
    private final EventBus eventBus;

    public PostCreator(PostCommandRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void createPost(Post post) {
        // TODO: check if user exists
        repository.createPost(post);
        // TODO: publish event
    }

}
