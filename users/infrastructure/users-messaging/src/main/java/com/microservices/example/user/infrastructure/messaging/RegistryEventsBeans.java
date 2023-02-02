package com.microservices.example.user.infrastructure.messaging;

import com.microservices.example.common.domain.events.UserCreatedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RegistryEventsBeans {

    @Bean
    public UserCreatedEvent userCreatedEvent() {
        return new UserCreatedEvent();
    }

}
