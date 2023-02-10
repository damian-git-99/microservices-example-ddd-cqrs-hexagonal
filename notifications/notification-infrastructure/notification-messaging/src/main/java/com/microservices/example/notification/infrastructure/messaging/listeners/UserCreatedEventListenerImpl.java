package com.microservices.example.notification.infrastructure.messaging.listeners;

import com.microservices.example.common.domain.events.UserCreatedEvent;
import com.microservices.example.notification.application.event.listeners.UserCreatedEventListener;
import com.microservices.example.notification.domain.entities.Email;
import com.microservices.example.notification.domain.repositories.EmailRepository;
import com.microservices.example.notification.domain.valueobjects.Message;
import com.microservices.example.notification.domain.valueobjects.Subject;
import com.microservices.example.notification.domain.valueobjects.ToEmail;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedEventListenerImpl implements UserCreatedEventListener {

    private static final String QUEUE_NAME = "notification.user.created.queue";
    private final EmailRepository emailRepository;

    public UserCreatedEventListenerImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @RabbitListener(queues = QUEUE_NAME)
    @Override
    public void listen(UserCreatedEvent event) {
        System.out.println("Received event: " + event);
        Email email  = new Email(
                new ToEmail(event.getEmail()),
                new Subject("Welcome to Microservices"),
                new Message("Welcome to Microservices")
        );
        emailRepository.saveEmail(email);
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
