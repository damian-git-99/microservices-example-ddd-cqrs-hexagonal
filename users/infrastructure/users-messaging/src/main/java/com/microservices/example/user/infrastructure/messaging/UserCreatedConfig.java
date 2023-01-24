package com.microservices.example.user.infrastructure.messaging;

import com.microservices.example.common.domain.events.UserCreatedEvent;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserCreatedConfig {
    private final UserCreatedEvent userCreatedEvent;
    private String exchange = "domain_events";

    public UserCreatedConfig() {
        this.userCreatedEvent = new UserCreatedEvent();
    }

    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Queue queue() {
        return new Queue(userCreatedEvent.eventName() + ".queue", false);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange internalTopicExchange) {
        return BindingBuilder
                .bind(queue)
                .to(internalTopicExchange)
                .with(userCreatedEvent.eventName());
    }

}
