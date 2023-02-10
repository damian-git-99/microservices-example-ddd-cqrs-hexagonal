package com.microservices.example.notification.domain.repositories;

import com.microservices.example.notification.domain.entities.Email;

import java.util.List;

public interface EmailRepository {
    void saveEmail(Email email);
    void updateIsSent(Email email);
    List<Email> findEmailsNotSent();
}
