package com.microservices.example.post.application.find_posts_by_user;

import com.microservices.example.common.domain.valueobjects.UserId;
import com.microservices.example.post.domain.entities.Post;
import com.microservices.example.post.domain.repositories.PostQueryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostFinderByUser {
    private final PostQueryRepository repository;

    public PostFinderByUser(PostQueryRepository repository) {
        this.repository = repository;
    }

    public List<FindPostsByUserResponse> find(UserId userId) {
        List<Post> posts = repository.findPostsByUser(userId);
        return posts.stream().map(p -> {
            FindPostsByUserResponse response = new FindPostsByUserResponse();
            response.setPostId(p.getId().getValue());
            response.setTitle(p.getTitle().getValue());
            response.setContent(p.getContent().getValue());
            return response;
        }).collect(Collectors.toList());
    }

}
