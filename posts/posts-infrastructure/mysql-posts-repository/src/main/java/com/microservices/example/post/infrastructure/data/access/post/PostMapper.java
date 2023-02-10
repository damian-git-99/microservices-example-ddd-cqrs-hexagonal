package com.microservices.example.post.infrastructure.data.access.post;

import com.microservices.example.common.domain.valueobjects.UserId;
import com.microservices.example.post.domain.entities.Post;
import com.microservices.example.post.domain.valueobjects.PostContent;
import com.microservices.example.post.domain.valueobjects.PostId;
import com.microservices.example.post.domain.valueobjects.PostTitle;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public PostEntity mapToEntity(Post post) {
        PostEntity postEntity = new PostEntity();
        postEntity.setId(post.getId().getValue());
        postEntity.setTitle(post.getTitle().getValue());
        postEntity.setContent(post.getContent().getValue());
        postEntity.setUserId(post.getUserId().getValue());
        return postEntity;
    }

    public Post mapToDomain(PostEntity postEntity) {
        Post post = new Post();
        post.setId(new PostId(postEntity.getId()));
        post.setTitle(new PostTitle(postEntity.getTitle()));
        post.setContent(new PostContent(postEntity.getContent()));
        post.setUserId(new UserId(postEntity.getUserId()));
        return post;
    }

}
