package com.microservices.example.user.infrastructure.data.accesss;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepositoryJPA extends JpaRepository<UserEntity, UUID> {

}
