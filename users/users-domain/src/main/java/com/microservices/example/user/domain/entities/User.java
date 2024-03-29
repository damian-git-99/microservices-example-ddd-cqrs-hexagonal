package com.microservices.example.user.domain.entities;

import com.microservices.example.common.domain.entity.BaseEntity;
import com.microservices.example.common.domain.valueobjects.UserId;
import com.microservices.example.user.domain.valueobjects.UserEmail;
import com.microservices.example.user.domain.valueobjects.UserName;

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
