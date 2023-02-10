package com.microservices.example.notification.domain.entities;

import com.microservices.example.notification.domain.valueobjects.Message;
import com.microservices.example.notification.domain.valueobjects.Subject;
import com.microservices.example.notification.domain.valueobjects.ToEmail;

public class Email {
    private final ToEmail toEmail;
    private final Subject subject;
    private final Message message;
    private boolean isSent;

    public Email(ToEmail toEmail, Subject subject, Message message) {
        this.toEmail = toEmail;
        this.subject = subject;
        this.message = message;
        this.isSent = false;
    }

    public ToEmail getToEmail() {
        return toEmail;
    }

    public boolean isSent() {
        return isSent;
    }

    public void setSent(boolean sent) {
        isSent = sent;
    }

    public Subject getSubject() {
        return subject;
    }

    public Message getMessage() {
        return message;
    }
}
