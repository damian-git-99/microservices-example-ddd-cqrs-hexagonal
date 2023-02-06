package com.microservices.example.notification.infrastructure.messaging.listeners;

import com.microservices.example.common.domain.events.UserCreatedEvent;
import com.microservices.example.notification.application.event.listeners.UserCreatedEventListener;
import com.microservices.example.notification.application.event.services.EmailService;
import com.microservices.example.notification.domain.Email;
import com.microservices.example.notification.domain.EmailRepository;
import com.microservices.example.notification.domain.ToEmail;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedEventListenerRabbitMQ implements UserCreatedEventListener {

    private static final String QUEUE_NAME = "user.created.queue";
    private final EmailRepository emailRepository;

    public UserCreatedEventListenerRabbitMQ(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @RabbitListener(queues = QUEUE_NAME)
    @Override
    public void listen(UserCreatedEvent event) {
        System.out.println("Received event: " + event);
        Email email  = new Email(new ToEmail(event.getEmail()));
        emailRepository.saveEmail(email);
    }

}
