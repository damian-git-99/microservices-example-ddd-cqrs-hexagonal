package com.microservices.example.user.application.create;

import com.microservices.example.user.domain.*;
import org.springframework.stereotype.Service;

@Service
public class UserCreator {

    private final UserRepository userRepository;

    public UserCreator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(UserId id, UserName username, UserEmail email) {
        User user = new User(id, username, email);
        userRepository.saveUser(user);
        // TODO: publish user created event
    }

}
