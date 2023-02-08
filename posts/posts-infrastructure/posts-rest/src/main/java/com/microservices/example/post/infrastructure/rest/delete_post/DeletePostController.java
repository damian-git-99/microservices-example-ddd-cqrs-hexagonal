package com.microservices.example.post.infrastructure.rest.delete_post;

import com.microservices.example.common.domain.command.CommandBus;
import com.microservices.example.post.application.delete_post.DeletePostCommand;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/posts")
public class DeletePostController {

    private final CommandBus commandBus;

    public DeletePostController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable UUID postId) throws Exception {
        commandBus.dispatch(new DeletePostCommand(postId));
    }

}
