package com.microservices.example.post.infrastructure.messaging.listeners;

import com.microservices.example.common.domain.events.UserCreatedEvent;
import com.microservices.example.post.application.listeners.UserCreatedEventListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedEventListenerImpl implements UserCreatedEventListener {

    private static final String QUEUE_NAME = "user.created.queue";

    @RabbitListener(queues = QUEUE_NAME)
    @Override
    public void listen(UserCreatedEvent event) {
        System.out.println("Received event: " + event);
    }
}
