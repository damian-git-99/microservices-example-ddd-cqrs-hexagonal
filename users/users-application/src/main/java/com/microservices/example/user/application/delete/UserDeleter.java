package com.microservices.example.user.application.delete;

import com.microservices.example.common.domain.events.EventBus;
import com.microservices.example.common.domain.events.UserDeletedEvent;
import com.microservices.example.common.domain.valueobjects.UserId;
import com.microservices.example.user.domain.repositories.UserCommandRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDeleter {

    private final UserCommandRepository userCommandRepository;
    private final EventBus eventBus;

    public UserDeleter(UserCommandRepository userCommandRepository, EventBus eventBus) {
        this.userCommandRepository = userCommandRepository;
        this.eventBus = eventBus;
    }

    public void delete(UserId userId) {
        userCommandRepository.deleteUser(userId);
        UserDeletedEvent event = new UserDeletedEvent(userId.getValue());
        eventBus.publish(event);
    }

}
