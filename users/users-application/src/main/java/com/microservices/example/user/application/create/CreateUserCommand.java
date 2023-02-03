package com.microservices.example.user.application.create;

import com.microservices.example.common.domain.command.Command;

import java.util.UUID;

public class CreateUserCommand extends Command {
    private final UUID id;
    private final String username;
    private final String email;

    public CreateUserCommand(UUID id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
