package com.microservices.example.user.application.delete;

import com.microservices.example.common.domain.command.Command;

import java.util.UUID;

public class DeleteUserCommand extends Command {
    private UUID userId;

    public DeleteUserCommand(UUID userId) {
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }
}
