package com.microservices.example.post.application.create_post;

import com.microservices.example.common.domain.command.Command;

import java.util.UUID;

public class CreatePostCommand extends Command {
    private final UUID id;
    private final String title;
    private final String content;
    private final UUID userId;

    public CreatePostCommand(UUID id, String title, String content, UUID userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public UUID getUserId() {
        return userId;
    }
}
