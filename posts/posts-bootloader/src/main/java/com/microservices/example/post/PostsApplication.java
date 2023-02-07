package com.microservices.example.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.microservices.example.post",
        "com.microservices.example.common"
})
@EntityScan(basePackages = {
        "com.microservices.example.post.infrastructure.data.access"
})
@EnableJpaRepositories(basePackages = {
        "com.microservices.example.post.infrastructure.data.access"
})
public class PostsApplication {
    public static void main(String[] args) {
        SpringApplication.run(PostsApplication.class, args);
    }
}
