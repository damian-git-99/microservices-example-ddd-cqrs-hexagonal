package com.microservices.example.post.domain.repositories;

import com.microservices.example.common.domain.valueobjects.UserId;
import com.microservices.example.post.domain.valueobjects.User;

import java.util.Optional;

public interface UserRepository {
    void saveUser(User user);
    Optional<User> findUserById(UserId id);
}
