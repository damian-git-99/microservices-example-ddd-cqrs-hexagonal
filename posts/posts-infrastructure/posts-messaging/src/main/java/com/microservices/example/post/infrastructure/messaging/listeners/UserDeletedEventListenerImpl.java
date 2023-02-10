package com.microservices.example.post.infrastructure.messaging.listeners;

import com.microservices.example.common.domain.events.UserDeletedEvent;
import com.microservices.example.post.application.listeners.UserDeletedEventListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserDeletedEventListenerImpl implements UserDeletedEventListener {

    private static final String QUEUE_NAME = "post.user.deleted.queue";

    @RabbitListener(queues = QUEUE_NAME)
    @Override
    public void listen(UserDeletedEvent event) {
        System.out.println("Received event: deleted user" + event.getId());
        System.out.println("Received event: " + event);
    }

    @Override
    public String queueName() {
        return QUEUE_NAME;
    }

    @Override
    public UserDeletedEvent domainEvent() {
        return new UserDeletedEvent();
    }
}
