package com.microservices.example.common.domain.events;

import java.io.Serializable;
import java.util.UUID;

public class UserCreatedEvent implements DomainEvent, Serializable {

    private UUID id;
    private String name;
    private String email;

    public UserCreatedEvent() {
    }

    public UserCreatedEvent(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String eventName() {
        return "user.created";
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
