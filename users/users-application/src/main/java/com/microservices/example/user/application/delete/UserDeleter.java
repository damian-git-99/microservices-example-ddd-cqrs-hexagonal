package com.microservices.example.user.application.delete;

import com.microservices.example.user.domain.UserId;
import com.microservices.example.user.domain.UserCommandRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDeleter {

    private final UserCommandRepository userCommandRepository;

    public UserDeleter(UserCommandRepository userCommandRepository) {
        this.userCommandRepository = userCommandRepository;
    }

    public void delete(UserId userId) {
        userCommandRepository.deleteUser(userId);
        // todo send event
    }

}
