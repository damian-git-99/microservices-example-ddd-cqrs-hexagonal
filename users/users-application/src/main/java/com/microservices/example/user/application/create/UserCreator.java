package com.microservices.example.user.application.create;

import com.microservices.example.common.domain.events.EventBus;
import com.microservices.example.common.domain.events.UserCreatedEvent;
import com.microservices.example.common.domain.valueobjects.UserId;
import com.microservices.example.user.domain.*;
import org.springframework.stereotype.Service;

@Service
public class UserCreator {

    private final UserCommandRepository userCommandRepository;
    private final EventBus eventBus;

    public UserCreator(UserCommandRepository userCommandRepository, EventBus eventBus) {
        this.userCommandRepository = userCommandRepository;
        this.eventBus = eventBus;
    }

    public void create(UserId id, UserName username, UserEmail email) {
        // TODO: check if email already exists
        User user = new User(id, username, email);
        userCommandRepository.saveUser(user);
        UserCreatedEvent event = new UserCreatedEvent(
                id.getValue().toString(),
                username.getValue(),
                email.getValue()
        );
        eventBus.publish(event);
    }

}
