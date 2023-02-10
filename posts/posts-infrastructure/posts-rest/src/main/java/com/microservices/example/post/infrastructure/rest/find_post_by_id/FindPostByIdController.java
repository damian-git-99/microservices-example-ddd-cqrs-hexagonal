package com.microservices.example.post.infrastructure.rest.find_post_by_id;

import com.microservices.example.common.domain.query.QueryBus;
import com.microservices.example.post.application.find_post_by_id.FindPostByIdQuery;
import com.microservices.example.post.application.find_post_by_id.FindPostByIdQueryResponse;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/posts")
public class FindPostByIdController {

    private final QueryBus queryBus;

    public FindPostByIdController(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    @GetMapping("/{postId}")
    public FindPostByIdQueryResponseController findPostById(@PathVariable UUID postId)
            throws Exception {
        FindPostByIdQuery query = new FindPostByIdQuery(postId);
        FindPostByIdQueryResponse response = queryBus.handle(query);
        return FindPostByIdQueryResponseController.builder()
                .id(response.getPostId())
                .title(response.getTitle())
                .content(response.getContent())
                .userId(response.getUserId())
                .build();
    }

}

@Data
@Builder
class FindPostByIdQueryResponseController {
    private UUID id;
    private String title;
    private String content;
    private UUID userId;
}
