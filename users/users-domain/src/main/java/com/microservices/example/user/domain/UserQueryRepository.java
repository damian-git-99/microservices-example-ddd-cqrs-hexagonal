package com.microservices.example.user.domain;

import java.util.Optional;

public interface UserQueryRepository {
    Optional<User> findUser(UserId id);
}
