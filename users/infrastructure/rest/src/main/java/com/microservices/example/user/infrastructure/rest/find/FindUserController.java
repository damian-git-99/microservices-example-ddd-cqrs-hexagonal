package com.microservices.example.user.infrastructure.rest.find;

import com.microservices.example.common.domain.query.QueryBus;
import com.microservices.example.user.application.find_user.FindUserQuery;
import com.microservices.example.user.application.find_user.FindUserResponse;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class FindUserController {
    private final QueryBus queryBus;

    public FindUserController(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    @GetMapping("/{userId}")
    public FindUserResponseController find(@PathVariable UUID userId) throws Exception {
        FindUserQuery query = new FindUserQuery(userId);
        FindUserResponse response = queryBus.handle(query);
        return FindUserResponseController.builder()
                .id(response.getId())
                .username(response.getName())
                .email(response.getEmail())
                .build();
    }

}

@Builder
@Data
class FindUserResponseController {
    private UUID id;
    private String username;
    private String email;
}
