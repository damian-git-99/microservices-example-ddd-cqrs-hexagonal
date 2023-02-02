package com.microservices.example.common.infrastructure.events;

import com.microservices.example.common.domain.events.DomainEvent;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@Primary
public class RegistryQueues {

    private final AmqpAdmin amqpAdmin;
    private final List<DomainEvent> events;

    public RegistryQueues(List<DomainEvent> events, AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
        this.events = events;
    }

    @PostConstruct
    public void createQueues() {
        for (DomainEvent event : this.events) {
            this.createQueue(event);
        }
    }

    private void createQueue(DomainEvent event) {
        String queueName = event.eventName() + ".queue";
        String exchange = "domain_events";
        String key = event.eventName() + ".key";
        amqpAdmin.declareQueue(new Queue(queueName, true));
        amqpAdmin.declareExchange(new TopicExchange(exchange));
        amqpAdmin.declareBinding(
                new Binding(
                        queueName,
                        Binding.DestinationType.QUEUE,
                        exchange,
                        key, null
                )
        );
    }

}
