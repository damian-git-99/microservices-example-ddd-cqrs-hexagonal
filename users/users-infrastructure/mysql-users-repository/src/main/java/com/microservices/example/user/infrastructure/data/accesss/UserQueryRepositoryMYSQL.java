package com.microservices.example.user.infrastructure.data.accesss;

import com.microservices.example.user.domain.User;
import com.microservices.example.user.domain.UserId;
import com.microservices.example.user.domain.UserQueryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserQueryRepositoryMYSQL implements UserQueryRepository {

    private final UserRepositoryJPA userRepositoryJPA;
    private final UserMapper userMapper;

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
