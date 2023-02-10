package com.microservices.example.post.infrastructure.data.access.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PostRepositoryJPA extends JpaRepository<PostEntity, UUID> {
    @Query("SELECT p FROM PostEntity p WHERE p.userId = ?1")
    List<PostEntity> findPostsByUserId(UUID userId);
}
