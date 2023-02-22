package com.microservices.example.user.infrastructure.rest.delete_user;

import com.microservices.example.common.domain.command.CommandBus;
import com.microservices.example.user.application.delete.DeleteUserCommand;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class DeleteUserController {
    private final CommandBus commandBus;

    public DeleteUserController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable UUID userId) throws Exception {
        commandBus.dispatch(new DeleteUserCommand(userId));
    }

}
