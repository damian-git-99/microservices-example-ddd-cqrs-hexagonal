package com.microservices.example.user.infrastructure.data.accesss;

import com.microservices.example.common.domain.valueobjects.UserId;
import com.microservices.example.user.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserCommandRepositoryMysql implements UserCommandRepository {

    private final UserRepositoryJPA userRepositoryJPA;
    private final UserMapper userMapper;

    @Override
    public void saveUser(User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        userRepositoryJPA.save(userEntity);
    }

    @Override
    public void deleteUser(UserId userId) {
        userRepositoryJPA.deleteById(userId.getValue());
    }

}
