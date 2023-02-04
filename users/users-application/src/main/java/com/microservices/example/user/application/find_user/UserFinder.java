package com.microservices.example.user.application.find_user;

import com.microservices.example.user.domain.User;
import com.microservices.example.user.domain.UserId;
import com.microservices.example.user.domain.UserNotFoundException;
import com.microservices.example.user.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserFinder {

    private final UserRepository userRepository;

    public UserFinder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public FindUserResponse find(UserId userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            String message = String.format("User with id %s not found", userId.getValue());
            throw new UserNotFoundException(message);
        }
        return FindUserResponse.builder()
                .id(user.get().getId().getValue())
                .name(user.get().getName().getValue())
                .email(user.get().getEmail().getValue())
                .build();
    }

}