package com.microservices.example.post.infrastructure.data.access.user;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
public class UserEntity {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    public UserEntity(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
