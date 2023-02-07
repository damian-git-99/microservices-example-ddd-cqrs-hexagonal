package com.microservices.example.post.infrastructure.data.access.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepositoryJPA extends JpaRepository<UserEntity, UUID> {
}
