package com.microservices.example.user.domain;

import com.microservices.example.common.domain.entity.BaseEntity;

public class User extends BaseEntity<UserId> {
    private UserName name;
    private UserEmail email;

    public User(UserId id, UserName name, UserEmail email) {
        super.setId(id);
        this.name = name;
        this.email = email;
    }

    public UserName getName() {
        return name;
    }

    public void setName(UserName name) {
        this.name = name;
    }

    public UserEmail getEmail() {
        return email;
    }

    public void setEmail(UserEmail email) {
        this.email = email;
    }
}
