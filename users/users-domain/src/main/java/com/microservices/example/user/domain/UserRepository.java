package com.microservices.example.user.domain;

import java.util.Optional;

public interface UserRepository {
    void saveUser(User user);
    void deleteUser(UserId userId);

    Optional<User> findUser(UserId id);
}
