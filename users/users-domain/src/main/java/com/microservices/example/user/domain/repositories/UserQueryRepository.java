package com.microservices.example.user.domain.repositories;

import com.microservices.example.common.domain.valueobjects.UserId;
import com.microservices.example.user.domain.entities.User;

import java.util.Optional;

public interface UserQueryRepository {
    Optional<User> findUser(UserId id);
}
