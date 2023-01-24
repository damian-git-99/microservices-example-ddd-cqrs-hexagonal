package com.microservices.example.common.domain.events;

public interface EventBus {
    void publish(DomainEvent event);
}
