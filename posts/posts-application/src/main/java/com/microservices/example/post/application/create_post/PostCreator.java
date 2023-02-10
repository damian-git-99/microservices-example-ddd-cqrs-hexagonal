package com.microservices.example.post.application.create_post;

import com.microservices.example.common.domain.events.EventBus;
import com.microservices.example.post.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostCreator {

    private final PostCommandRepository repository;
    private final UserRepository userRepository;
    private final EventBus eventBus;

    public PostCreator(PostCommandRepository repository, UserRepository userRepository, EventBus eventBus) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.eventBus = eventBus;
    }

    public void createPost(Post post) {
        Optional<User> user = userRepository.findUserById(post.getUserId());
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found: " + post.getUserId().getValue());
        }
        repository.createPost(post);
        // TODO: publish event
    }

}
