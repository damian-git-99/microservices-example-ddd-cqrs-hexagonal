package com.microservices.example.common.infrastructure.events;

import com.microservices.example.common.domain.events.DomainEvent;
import com.microservices.example.common.domain.events.Listener;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Primary
public class RegistryQueuePerListener {

    private final List<Listener<?>> listeners;
    private final AmqpAdmin amqpAdmin;
    private final String exchange = "domain_events";

    public RegistryQueuePerListener(List<Listener<?>> listeners, AmqpAdmin amqpAdmin) {
        this.listeners = listeners;
        Set<String> queues = new HashSet<>();
        for (Listener<?> listener : this.listeners) {
            if (!queues.add(listener.queueName())) {
                throw new RuntimeException("Queue name already exists: " + listener.queueName());
            }
        }
        queues = null;
        this.amqpAdmin = amqpAdmin;
    }

    @PostConstruct
    public void createQueues() {
        for (Listener listener : this.listeners) {
            this.createQueue(listener.domainEvent(), listener.queueName());
        }
    }

    public void createQueue(DomainEvent event, String queueName) {
        String key = event.keyName() + ".key";
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
