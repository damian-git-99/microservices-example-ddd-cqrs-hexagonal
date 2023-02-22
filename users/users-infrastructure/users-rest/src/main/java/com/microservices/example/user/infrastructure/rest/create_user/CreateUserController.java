package com.microservices.example.user.infrastructure.rest.create_user;

import com.microservices.example.common.domain.command.CommandBus;
import com.microservices.example.user.application.create.CreateUserCommand;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateUserRequest request) throws Exception {
        CreateUserCommand command = new CreateUserCommand(
                request.getId(),
                request.getUsername(),
                request.getEmail()
        );
        commandBus.dispatch(command);
    }

}

@Data
@NoArgsConstructor
class CreateUserRequest {
    private String username;
    private String email;
    private UUID id;
}
