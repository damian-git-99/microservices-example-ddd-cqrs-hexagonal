package com.microservices.example.post.infrastructure.data.access.post;

import com.microservices.example.common.domain.valueobjects.UserId;
import com.microservices.example.post.domain.Post;
import com.microservices.example.post.domain.PostId;
import com.microservices.example.post.domain.PostQueryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PostQueryRepositoryMYSQL implements PostQueryRepository {

    private final PostRepositoryJPA postRepositoryJPA;
    private final PostMapper postMapper;

    @Override
    public List<Post> findPostsByUser(UserId userId) {
        return postRepositoryJPA.findAllByUserId(userId.getValue())
                .stream()
                .map(postMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Post> findPostById(PostId id) {
        return postRepositoryJPA.findById(id.getValue())
                .map(postMapper::mapToDomain);
    }

}
