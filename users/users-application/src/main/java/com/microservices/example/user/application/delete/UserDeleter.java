package com.microservices.example.user.application.delete;

import com.microservices.example.user.domain.UserId;
import com.microservices.example.user.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDeleter {

    private final UserRepository userRepository;

    public UserDeleter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void delete(UserId userId) {
        userRepository.deleteUser(userId);
        // todo send event
    }

}
