package com.microservices.example.user.domain;

import com.microservices.example.common.domain.valueobjects.UserId;

import java.util.Optional;

public interface UserQueryRepository {
    Optional<User> findUser(UserId id);
}
