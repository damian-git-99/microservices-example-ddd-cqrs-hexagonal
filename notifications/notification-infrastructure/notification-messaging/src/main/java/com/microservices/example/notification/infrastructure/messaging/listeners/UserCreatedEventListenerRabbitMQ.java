package com.microservices.example.notification.infrastructure.messaging.listeners;

import com.microservices.example.common.domain.events.UserCreatedEvent;
import com.microservices.example.notification.application.event.listeners.UserCreatedEventListener;
import com.microservices.example.notification.application.event.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedEventListenerRabbitMQ implements UserCreatedEventListener {

    private static final String QUEUE_NAME = "user.created.queue";
    private final EmailService emailService;

    public UserCreatedEventListenerRabbitMQ(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = QUEUE_NAME)
    @Override
    public void listen(UserCreatedEvent event) {
        emailService.sendEmail(
                event.getEmail(),
                "Welcome to Microservices",
                "Welcome to Microservices"
        );
    }

}
