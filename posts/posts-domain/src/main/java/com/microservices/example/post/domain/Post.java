package com.microservices.example.post.domain;

import com.microservices.example.common.domain.entity.BaseEntity;
import com.microservices.example.common.domain.valueobjects.UserId;

public class Post extends BaseEntity<PostId> {
    private PostTitle title;
    private PostContent content;
    private UserId userId;

    public Post() {
    }

    public Post(PostId id, PostTitle title, PostContent content, UserId userId) {
        super.setId(id);
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public PostTitle getTitle() {
        return title;
    }

    public void setTitle(PostTitle title) {
        this.title = title;
    }

    public PostContent getContent() {
        return content;
    }

    public void setContent(PostContent content) {
        this.content = content;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }
}
