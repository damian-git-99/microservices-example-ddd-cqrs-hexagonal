package com.microservices.example.user.application.find_user;

import com.microservices.example.common.domain.query.QueryHandler;
import com.microservices.example.user.domain.UserId;
import org.springframework.stereotype.Component;

@Component
public class FindUserQueryHandler implements QueryHandler<FindUserResponse, FindUserQuery> {

    private final UserFinder userFinder;

    public FindUserQueryHandler(UserFinder userFinder) {
        this.userFinder = userFinder;
    }

    @Override
    public FindUserResponse handle(FindUserQuery query) {
        UserId userId = new UserId(query.getUserId());
        return userFinder.find(userId);
    }

}
