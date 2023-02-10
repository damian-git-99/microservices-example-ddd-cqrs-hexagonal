package com.microservices.example.post.infrastructure.rest.find_posts_by_user;

import com.microservices.example.common.domain.query.QueryBus;
import com.microservices.example.common.domain.valueobjects.UserId;
import com.microservices.example.post.application.find_posts_by_user.FindPostsByUserQuery;
import com.microservices.example.post.application.find_posts_by_user.FindPostsByUserResponse;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/posts")
public class FindPostsByUser {

    private final QueryBus queryBus;

    public FindPostsByUser(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    @GetMapping("/user-posts/{userId}")
    public List<FindPostsByUserResponse> findPostsByUser(@PathVariable UUID userId) throws Exception {
        FindPostsByUserQuery query = new FindPostsByUserQuery(userId);
        return queryBus.handle(query);
    }

}

@Data
@Builder
class FindPostsByUserResponseController {
    private UUID id;
    private String title;
    private String content;
}
