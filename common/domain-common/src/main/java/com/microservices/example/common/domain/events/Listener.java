package com.microservices.example.common.domain.events;

public interface Listener<T extends DomainEvent> {
    void listen(T event);
    String queueName();
    T domainEvent();
}
