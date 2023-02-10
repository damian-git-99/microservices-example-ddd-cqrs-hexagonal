package com.microservices.example.user.infrastructure.data.accesss;

import com.microservices.example.common.domain.valueobjects.UserId;
import com.microservices.example.user.domain.entities.User;
import com.microservices.example.user.domain.valueobjects.UserEmail;
import com.microservices.example.user.domain.valueobjects.UserName;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toEntity(User user) {
        return new UserEntity(
                user.getId().getValue(),
                user.getName().getValue(),
                user.getEmail().getValue()
        );
    }

    public User toDomain(UserEntity userEntity) {
        return new User(
                new UserId(userEntity.getId()),
                new UserName(userEntity.getUsername()),
                new UserEmail(userEntity.getEmail())
        );
    }

}
