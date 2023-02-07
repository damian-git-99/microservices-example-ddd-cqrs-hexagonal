package com.microservices.example.post.application.find_post_by_id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindPostByIdQueryResponse {
    private UUID postId;
    private String title;
    private String content;
    private UUID userId;
}
