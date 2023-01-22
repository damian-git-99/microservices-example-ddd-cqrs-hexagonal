package com.microservices.example.user.infraestructure.rest.create;

import com.microservices.example.common.domain.command.CommandBus;
import com.microservices.example.user.application.create.CreateUserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class CreateUserController {

    private final CommandBus commandBus;

    @Autowired
    public CreateUserController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @PostMapping
    public void create() throws Exception {
        CreateUserCommand command = new CreateUserCommand(
                UUID.randomUUID(),
                "damian",
                "damian@gmail.com"
        );
        commandBus.dispatch(command);
    }
}
