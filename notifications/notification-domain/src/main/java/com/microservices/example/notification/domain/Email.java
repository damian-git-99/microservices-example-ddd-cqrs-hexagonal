package com.microservices.example.notification.domain;

public class Email {
    private final EmailId id;
    private final ToEmail toEmail;
    private boolean isSent;

    public Email(EmailId id, ToEmail toEmail) {
        this.id = id;
        this.toEmail = toEmail;
    }

    public EmailId getId() {
        return id;
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
