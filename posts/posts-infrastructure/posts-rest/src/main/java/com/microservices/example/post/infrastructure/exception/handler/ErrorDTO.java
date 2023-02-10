package com.microservices.example.post.infrastructure.exception.handler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {
    private String code;
    private String message;
}
