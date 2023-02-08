package com.microservices.example.post.infrastructure.messaging.listeners;

import com.microservices.example.common.domain.events.UserCreatedEvent;
import com.microservices.example.common.domain.valueobjects.UserId;
import com.microservices.example.post.application.listeners.UserCreatedEventListener;
import com.microservices.example.post.domain.User;
import com.microservices.example.post.domain.UserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedEventListenerImpl implements UserCreatedEventListener {

    private static final String QUEUE_NAME = "post.user.created.queue";

    private final UserRepository userRepository;

    public UserCreatedEventListenerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RabbitListener(queues = QUEUE_NAME)
    @Override
    public void listen(UserCreatedEvent event) {
        System.out.println("Received event: " + event);
        User user = new User(new UserId(event.getId()));
        userRepository.saveUser(user);
    }

    @Override
    public String queueName() {
        return QUEUE_NAME;
    }

    @Override
    public UserCreatedEvent domainEvent() {
        return new UserCreatedEvent();
    }
}
