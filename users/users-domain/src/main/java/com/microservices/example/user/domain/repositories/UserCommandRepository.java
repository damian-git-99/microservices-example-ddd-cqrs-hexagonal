package com.microservices.example.user.domain.repositories;


import com.microservices.example.common.domain.valueobjects.UserId;
import com.microservices.example.user.domain.entities.User;

public interface UserCommandRepository {
    void saveUser(User user);

    void deleteUser(UserId userId);
}
