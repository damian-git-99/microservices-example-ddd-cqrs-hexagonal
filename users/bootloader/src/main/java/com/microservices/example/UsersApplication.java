package com.microservices.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.microservices.example.user",
        "com.microservices.example.common"
})
@EntityScan(basePackages = {
        "com.microservices.example.user.infrastructure.data.accesss"
})
@EnableJpaRepositories(basePackages = {
        "com.microservices.example.user.infrastructure.data.accesss"
})
public class UsersApplication {
    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }
}
