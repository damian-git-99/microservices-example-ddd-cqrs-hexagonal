package com.microservices.example.user.application.delete;

import com.microservices.example.common.domain.command.CommandHandler;
import com.microservices.example.common.domain.valueobjects.UserId;
import org.springframework.stereotype.Component;

@Component
public class CommandDeleteUserHandler implements CommandHandler<DeleteUserCommand> {

    private final UserDeleter userDeleter;

    public CommandDeleteUserHandler(UserDeleter userDeleter) {
        this.userDeleter = userDeleter;
    }

    @Override
    public void handle(DeleteUserCommand command) throws Exception {
        UserId userId = new UserId(command.getUserId());
        userDeleter.delete(userId);
    }

}
