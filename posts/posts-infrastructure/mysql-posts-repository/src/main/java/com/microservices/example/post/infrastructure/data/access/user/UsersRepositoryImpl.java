package com.microservices.example.post.infrastructure.data.access.user;

import com.microservices.example.common.domain.valueobjects.UserId;
import com.microservices.example.post.domain.valueobjects.User;
import com.microservices.example.post.domain.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UsersRepositoryImpl implements UserRepository {

    private final UserRepositoryJPA userRepositoryJPA;

    @Override
    public void saveUser(User user) {
        UserEntity userEntity = new UserEntity(user.getId().getValue());
        userRepositoryJPA.save(userEntity);
    }

    @Override
    public void deleteUser(UserId userId) {
        userRepositoryJPA.deleteById(userId.getValue());
    }

    @Override
    public Optional<User> findUserById(UserId id) {
        UserEntity userEntity = userRepositoryJPA.findById(id.getValue())
                .orElse(null);
        return Optional.ofNullable(userEntity)
                .map(userEntity1 -> new User(new UserId(userEntity1.getId())));
    }

}
