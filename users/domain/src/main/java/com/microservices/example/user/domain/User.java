package com.microservices.example.user.domain;

public class User {
    private UserId id;
    private UserName name;
    private UserEmail email;

    public User(UserId id, UserName name, UserEmail email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserId getId() {
        return id;
    }

    public void setId(UserId id) {
        this.id = id;
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
