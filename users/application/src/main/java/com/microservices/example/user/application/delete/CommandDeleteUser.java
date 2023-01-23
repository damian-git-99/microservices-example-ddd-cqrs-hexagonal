package com.microservices.example.user.application.delete;

import com.microservices.example.common.domain.command.Command;

import java.util.UUID;

public class CommandDeleteUser extends Command {
    private UUID userId;

    public CommandDeleteUser(UUID userId) {
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }
}
