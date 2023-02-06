package com.microservices.example.notification.infrastructure.data.access;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EmailRepositoryJPA extends JpaRepository<EmailEntity, Integer> {
    @Query("select e from EmailEntity e where e.isSent = false")
    List<EmailEntity> findByIsSentFalse();

    @Modifying
    @Query("update EmailEntity e set e.isSent = true where e.toEmail = ?1")
    void updateIsSent(String email);
}
