package com.microservices.example.common.domain.events;

import java.util.UUID;

public class UserDeletedEvent implements DomainEvent {
    private UUID id;

    public UserDeletedEvent() {
    }

    public UserDeletedEvent(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String keyName() {
        return "user.deleted";
    }
}
