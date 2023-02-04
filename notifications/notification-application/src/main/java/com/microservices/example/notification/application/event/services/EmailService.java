package com.microservices.example.notification.application.event.services;

public interface EmailService {
    void sendEmail(String toEmail, String subject, String message);
}
