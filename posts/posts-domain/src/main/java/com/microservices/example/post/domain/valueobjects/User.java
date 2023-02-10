package com.microservices.example.post.domain.valueobjects;

import com.microservices.example.common.domain.valueobjects.UserId;

public class User {
    private UserId id;

    public User(UserId id) {
        this.id = id;
    }

    public UserId getId() {
        return id;
    }
}
