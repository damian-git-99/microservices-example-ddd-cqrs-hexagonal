package com.microservices.example.notification.application.event.listeners;

import com.microservices.example.common.domain.events.Listener;
import com.microservices.example.common.domain.events.UserCreatedEvent;


public interface UserCreatedEventListener extends Listener<UserCreatedEvent> {

}
