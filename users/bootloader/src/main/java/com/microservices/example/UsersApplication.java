package com.microservices.example;

import com.microservices.example.user.application.create.CreateUserCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.microservices.example"})
public class UsersApplication {
    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
        CreateUserCommand command = null;
    }
}
