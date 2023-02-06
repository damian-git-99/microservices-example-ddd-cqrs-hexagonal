package com.microservices.example.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {
        "com.microservices.example.notification",
        "com.microservices.example.common"
})
@EntityScan(basePackages = {
        "com.microservices.example.notification.infrastructure.data.access"
})
@EnableJpaRepositories(basePackages = {
        "com.microservices.example.notification.infrastructure.data.access"
})
@EnableScheduling
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }
}
