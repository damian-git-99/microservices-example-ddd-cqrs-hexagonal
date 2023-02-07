package com.microservices.example.post.application.find_post_by_id;


import com.microservices.example.common.domain.query.QueryHandler;
import com.microservices.example.post.domain.PostId;
import org.springframework.stereotype.Component;

@Component
public class FindPostByIdQueryHandler implements QueryHandler<FindPostByIdQueryResponse, FindPostByIdQuery> {

    private final PostFinderById postFinderById;

    public FindPostByIdQueryHandler(PostFinderById postFinderById) {
        this.postFinderById = postFinderById;
    }

    @Override
    public FindPostByIdQueryResponse handle(FindPostByIdQuery query) throws Exception {
        PostId postId = new PostId(query.getPostId());
        return postFinderById.find(postId);
    }
}
