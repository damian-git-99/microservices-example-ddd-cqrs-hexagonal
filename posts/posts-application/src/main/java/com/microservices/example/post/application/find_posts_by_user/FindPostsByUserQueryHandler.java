package com.microservices.example.post.application.find_posts_by_user;

import com.microservices.example.common.domain.query.QueryHandler;
import com.microservices.example.common.domain.valueobjects.UserId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindPostsByUserQueryHandler implements QueryHandler<List<FindPostsByUserResponse>, FindPostsByUserQuery> {

    private final PostFinderByUser finder;

    public FindPostsByUserQueryHandler(PostFinderByUser finder) {
        this.finder = finder;
    }

    @Override
    public List<FindPostsByUserResponse> handle(FindPostsByUserQuery query) throws Exception {
        UserId userId = new UserId(query.getUserId());
        return finder.find(userId);
    }
}
