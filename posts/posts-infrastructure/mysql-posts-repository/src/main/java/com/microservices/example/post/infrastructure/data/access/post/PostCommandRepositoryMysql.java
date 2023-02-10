package com.microservices.example.post.infrastructure.data.access.post;

import com.microservices.example.post.domain.Post;
import com.microservices.example.post.domain.PostCommandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PostCommandRepositoryMysql implements PostCommandRepository {

    private final PostRepositoryJPA postRepositoryJPA;
    private final PostMapper postMapper;

    @Override
    public void createPost(Post post) {
        postRepositoryJPA.save(postMapper.mapToEntity(post));
    }

    @Override
    public void deletePost(Post post) {
        postRepositoryJPA.delete(postMapper.mapToEntity(post));
    }

}
