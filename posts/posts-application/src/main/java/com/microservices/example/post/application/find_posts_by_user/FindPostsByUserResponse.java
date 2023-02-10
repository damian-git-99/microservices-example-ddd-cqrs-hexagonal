package com.microservices.example.post.application.find_posts_by_user;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
public class FindPostsByUserResponse {
    private UUID postId;
    private String title;
    private String content;

    public FindPostsByUserResponse(UUID postId, String title, String content) {
        this.postId = postId;
        this.title = title;
        this.content = content;
    }
}
