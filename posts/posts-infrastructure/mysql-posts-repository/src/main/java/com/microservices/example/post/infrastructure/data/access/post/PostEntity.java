package com.microservices.example.post.infrastructure.data.access.post;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Table(name = "posts")
public class PostEntity {

    @Id
    @Type(type = "uuid-char")
    private UUID id;
    private String title;
    private String content;
    private UUID userId;

    public PostEntity(UUID id, String title, String content, UUID userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
