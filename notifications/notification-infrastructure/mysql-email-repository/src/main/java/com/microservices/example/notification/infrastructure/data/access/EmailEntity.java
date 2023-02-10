package com.microservices.example.notification.infrastructure.data.access;

import javax.persistence.*;

@Entity
@Table(name = "emails")
public class EmailEntity {

    @Id
    @Column(unique = true)
    private String toEmail;
    private String subject;
    private String message;
    private boolean isSent;

    public EmailEntity() {
    }

    public EmailEntity(String toEmail, boolean isSent) {
        this.toEmail = toEmail;
        this.isSent = isSent;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public boolean isSent() {
        return isSent;
    }

    public void setSent(boolean sent) {
        isSent = sent;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
