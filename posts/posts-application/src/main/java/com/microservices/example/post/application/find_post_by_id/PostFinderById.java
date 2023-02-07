package com.microservices.example.post.application.find_post_by_id;

import com.microservices.example.post.domain.Post;
import com.microservices.example.post.domain.PostId;
import com.microservices.example.post.domain.PostQueryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostFinderById {

    private final PostQueryRepository repository;

    public PostFinderById(PostQueryRepository repository) {
        this.repository = repository;
    }

    public FindPostByIdQueryResponse find(PostId postId) {
        Optional<Post> post = repository.findPostById(postId);
        if (post.isEmpty()) {
            // TODO: use a custom exception
            throw new RuntimeException("Post not found");
        }
        return FindPostByIdQueryResponse.builder()
                .postId(post.get().getId().getValue())
                .title(post.get().getTitle().getValue())
                .content(post.get().getContent().getValue())
                .userId(post.get().getUserId().getValue())
                .build();
    }
}
