package com.microservices.example.user.application.find_user;

import com.microservices.example.common.domain.valueobjects.UserId;
import com.microservices.example.user.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserFinder {

    private final UserQueryRepository userCommandRepository;

    public UserFinder(UserQueryRepository userCommandRepository) {
        this.userCommandRepository = userCommandRepository;
    }

    public FindUserResponse find(UserId userId) {
        Optional<User> user = userCommandRepository.findUser(userId);
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
