package com.microservices.example.post.application.delete_post;

import com.microservices.example.common.domain.command.Command;

import java.util.UUID;

public class DeletePostCommand extends Command {
    private final UUID id;

    public DeletePostCommand(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
