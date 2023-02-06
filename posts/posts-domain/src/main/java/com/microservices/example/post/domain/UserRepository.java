package com.microservices.example.post.domain;

import com.microservices.example.common.domain.valueobjects.UserId;

import java.util.Optional;

public interface UserRepository {
    void saveUser(User user);
    Optional<User> findUserById(UserId id);
}
