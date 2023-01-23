package com.microservices.example.user.application.create;

import com.microservices.example.common.domain.command.CommandHandler;
import com.microservices.example.user.domain.UserEmail;
import com.microservices.example.user.domain.UserId;
import com.microservices.example.user.domain.UserName;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand> {

    private final UserCreator userCreator;

    public CreateUserCommandHandler(UserCreator userCreator) {
        this.userCreator = userCreator;
    }

    @Override
    public void handle(CreateUserCommand command) {
        UserId id = new UserId(command.getId());
        UserName name = new UserName(command.getUsername());
        UserEmail email = new UserEmail(command.getEmail());
        userCreator.create(id, name, email);
    }

}
