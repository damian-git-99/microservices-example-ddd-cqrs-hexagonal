package com.microservices.example.post.infrastructure.data.access.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepositoryJPA extends JpaRepository<PostEntity, UUID> {
    List<PostEntity> findAllByUserId(UUID userId);
}
