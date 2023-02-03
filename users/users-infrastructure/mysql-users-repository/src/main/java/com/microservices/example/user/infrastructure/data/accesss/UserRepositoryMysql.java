package com.microservices.example.user.infrastructure.data.accesss;

import com.microservices.example.user.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserRepositoryMysql implements UserRepository {

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

    @Override
    public Optional<User> findUser(UserId id) {
        Optional<UserEntity> entity = userRepositoryJPA.findById(id.getValue());
        if (entity.isEmpty()) {
            return Optional.empty();
        }
        User user = userMapper.toDomain(entity.get());
        return Optional.of(user);
    }

}
