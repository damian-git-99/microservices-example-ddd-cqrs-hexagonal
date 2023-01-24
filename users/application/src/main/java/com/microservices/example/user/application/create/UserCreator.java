package com.microservices.example.user.application.create;

import com.microservices.example.common.domain.events.EventBus;
import com.microservices.example.common.domain.events.UserCreatedEvent;
import com.microservices.example.user.domain.*;
import org.springframework.stereotype.Service;

@Service
public class UserCreator {

    private final UserRepository userRepository;
    private final EventBus eventBus;

    public UserCreator(UserRepository userRepository, EventBus eventBus) {
        this.userRepository = userRepository;
        this.eventBus = eventBus;
    }

    public void create(UserId id, UserName username, UserEmail email) {
        User user = new User(id, username, email);
        userRepository.saveUser(user);
        // TODO: publish user created event
        eventBus.publish(new UserCreatedEvent(id.getValue().toString(), username.getValue(), email.getValue()));
    }

}
