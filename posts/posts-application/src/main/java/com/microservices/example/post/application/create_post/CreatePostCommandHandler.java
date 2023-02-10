package com.microservices.example.post.application.create_post;

import com.microservices.example.common.domain.command.CommandHandler;
import com.microservices.example.common.domain.valueobjects.UserId;
import com.microservices.example.post.domain.entities.Post;
import com.microservices.example.post.domain.valueobjects.PostContent;
import com.microservices.example.post.domain.valueobjects.PostId;
import com.microservices.example.post.domain.valueobjects.PostTitle;
import org.springframework.stereotype.Component;

@Component
public class CreatePostCommandHandler implements CommandHandler<CreatePostCommand> {

    private final PostCreator postCreator;

    public CreatePostCommandHandler(PostCreator postCreator) {
        this.postCreator = postCreator;
    }

    @Override
    public void handle(CreatePostCommand command) throws Exception {
        PostId postId = new PostId(command.getId());
        PostTitle postTitle = new PostTitle(command.getTitle());
        PostContent postContent = new PostContent(command.getContent());
        UserId userId = new UserId(command.getUserId());
        postCreator.createPost(
                new Post(postId, postTitle, postContent, userId)
        );
    }

}
