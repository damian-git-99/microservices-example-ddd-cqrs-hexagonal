package com.microservices.example.common.infrastructure.events;

import com.microservices.example.common.domain.events.DomainEvent;
import com.microservices.example.common.domain.events.EventBus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventBusRabbitMQ implements EventBus {

    private final  String EXCHANGE = "domain_events";

    private final RabbitTemplate rabbitTemplate;

    public EventBusRabbitMQ(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publish(DomainEvent event) {
        rabbitTemplate.convertAndSend(EXCHANGE, event.eventName() + ".key", event);
    }

}
