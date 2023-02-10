package com.microservices.example.notification.infrastructure.data.access;

import com.microservices.example.notification.domain.entities.Email;
import com.microservices.example.notification.domain.valueobjects.Message;
import com.microservices.example.notification.domain.valueobjects.Subject;
import com.microservices.example.notification.domain.valueobjects.ToEmail;

import java.util.List;
import java.util.stream.Collectors;

public class EmailMapper {

    public EmailEntity toEntity(Email email) {
        return new EmailEntity(
                email.getToEmail().getValue(),
                email.isSent()
        );
    }

    public Email toDomain(EmailEntity emailEntity) {
        return new Email(
                new ToEmail(emailEntity.getToEmail()),
                new Subject(emailEntity.getSubject()),
                new Message(emailEntity.getMessage())
        );
    }

    public List<Email> toDomain(List<EmailEntity> emailEntities) {
        return emailEntities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }


}
