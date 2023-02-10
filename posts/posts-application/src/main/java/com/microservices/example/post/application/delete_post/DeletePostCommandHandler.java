package com.microservices.example.post.application.delete_post;

import com.microservices.example.common.domain.command.CommandHandler;
import com.microservices.example.post.domain.entities.Post;
import com.microservices.example.post.domain.valueobjects.PostId;
import org.springframework.stereotype.Component;

@Component
public class DeletePostCommandHandler implements CommandHandler<DeletePostCommand> {

    private final PostDeleter postDeleter;

    public DeletePostCommandHandler(PostDeleter postDeleter) {
        this.postDeleter = postDeleter;
    }

    @Override
    public void handle(DeletePostCommand command) throws Exception {
        Post post = new Post();
        post.setId(new PostId(command.getId()));
        postDeleter.deletePost(post);
    }

}
