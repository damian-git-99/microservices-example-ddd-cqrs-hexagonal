package com.microservices.example.user.domain;


public interface UserCommandRepository {
    void saveUser(User user);

    void deleteUser(UserId userId);
}
