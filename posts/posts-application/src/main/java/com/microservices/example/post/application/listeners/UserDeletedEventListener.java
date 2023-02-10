package com.microservices.example.post.application.listeners;

import com.microservices.example.common.domain.events.Listener;
import com.microservices.example.common.domain.events.UserDeletedEvent;

public interface UserDeletedEventListener extends Listener<UserDeletedEvent> {
}
