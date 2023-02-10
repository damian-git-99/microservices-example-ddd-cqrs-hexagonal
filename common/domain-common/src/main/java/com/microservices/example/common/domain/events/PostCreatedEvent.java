package com.microservices.example.common.domain.events;

import java.util.UUID;

public class PostCreatedEvent implements DomainEvent {
    private UUID id;
    private String title;
    private UUID userId;

    public PostCreatedEvent() {
    }

    public PostCreatedEvent(UUID id, String title, UUID userId) {
        this.id = id;
        this.title = title;
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public String keyName() {
        return "post.created";
    }
}
