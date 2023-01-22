package com.microservices.example.user.domain;

import java.util.Optional;

public interface UserRepository {
    void saveUser(User user);

    Optional<User> findUser(UserId id);
}
