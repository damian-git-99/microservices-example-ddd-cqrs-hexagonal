package com.microservices.example.user.domain;


import com.microservices.example.common.domain.valueobjects.UserId;

public interface UserCommandRepository {
    void saveUser(User user);

    void deleteUser(UserId userId);
}
