package com.microservices.example.user.application.find_user;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class FindUserResponse {
    private UUID id;
    private String name;
    private String email;
}
