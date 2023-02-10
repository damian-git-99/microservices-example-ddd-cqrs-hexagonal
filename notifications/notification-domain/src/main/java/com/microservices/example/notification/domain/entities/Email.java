package com.microservices.example.notification.domain.entities;

import com.microservices.example.notification.domain.valueobjects.ToEmail;

public class Email {
    private final ToEmail toEmail;
    private boolean isSent;

    public Email(ToEmail toEmail) {
        this.toEmail = toEmail;
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
}
