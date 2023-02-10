package com.microservices.example.post.infrastructure.rest.create_post;

import com.microservices.example.common.domain.command.CommandBus;
import com.microservices.example.post.application.create_post.CreatePostCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/posts")
public class CreatePostController {

    private final CommandBus commandBus;

    public CreatePostController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody CreatePostRequest request) throws Exception {
        CreatePostCommand command = new CreatePostCommand(
                request.getId(),
                request.getTitle(),
                request.getContent(),
                request.getUserId()
        );
        commandBus.dispatch(command);
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class CreatePostRequest {
    private UUID id;
    private String title;
    private String content;
    private UUID userId;
}
