package com.microservices.example.notification.infrastructure.data.access;

import com.microservices.example.notification.domain.Email;
import com.microservices.example.notification.domain.EmailRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailRepositoryImpl implements EmailRepository {

    private final EmailRepositoryJPA emailRepositoryJPA;
    private final EmailMapper emailMapper;

    public EmailRepositoryImpl(EmailRepositoryJPA emailRepositoryJPA) {
        this.emailRepositoryJPA = emailRepositoryJPA;
        this.emailMapper = new EmailMapper();
    }

    @Override
    public void saveEmail(Email email) {
        EmailEntity emailEntity = emailMapper.toEntity(email);
        emailRepositoryJPA.save(emailEntity);
    }

    @Override
    public void updateIsSent(Email email) {
        emailRepositoryJPA.updateIsSent(email.getToEmail().getValue());
    }

    @Override
    public List<Email> findEmailsNotSent() {
        List<EmailEntity> emailEntities = emailRepositoryJPA.findByIsSentFalse();
        return emailMapper.toDomain(emailEntities);
    }

}

