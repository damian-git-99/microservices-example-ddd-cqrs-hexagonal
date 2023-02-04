package com.microservices.example.notification.domain;

import java.util.List;

public interface EmailRepository {
    void saveEmail(Email email);
    List<Email> findEmailsNotSent();
}
