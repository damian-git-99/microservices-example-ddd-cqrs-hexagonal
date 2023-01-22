package com.microservices.example.user.application.create;

import com.microservices.example.common.domain.command.CommandHandler;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand> {

    @Override
    public void handle(CreateUserCommand command) {
        System.out.println("Command Handler: " + command);
    }

}
