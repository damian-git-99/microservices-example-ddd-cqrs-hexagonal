package com.microservices.example.notification.infrastructure.email.service;

import com.microservices.example.notification.application.event.scheduler.SchedulerEmailService;
import com.microservices.example.notification.application.event.services.EmailService;
import com.microservices.example.notification.domain.entities.Email;
import com.microservices.example.notification.domain.repositories.EmailRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class SchedulerEmailServiceImpl implements SchedulerEmailService {

    private final EmailRepository emailRepository;
    private final EmailService emailService;
    private static final long FIXED_RATE = 5000;

    public SchedulerEmailServiceImpl(EmailRepository emailRepository, EmailService emailService) {
        this.emailRepository = emailRepository;
        this.emailService = emailService;
    }

    @Scheduled(fixedRate = FIXED_RATE)
    @Override
    @Transactional
    public void sendEmails() {
        List<Email> emails = emailRepository.findEmailsNotSent();
        System.out.println("Sending emails: " + emails.size());
        for (Email email : emails) {
            sendEmail(email);
        }
    }

    @Transactional
    public void sendEmail(Email email) {
        try {
            String toEmail = email.getToEmail().getValue();
            emailService.sendEmail(toEmail, "Hello", "Hello World");
            emailRepository.updateIsSent(email);
            System.out.println("Email sent: " + toEmail + " successfully");
        } catch (Exception e) {
            System.out.println("Error sending email: " + e.getMessage());
        }
    }


}
