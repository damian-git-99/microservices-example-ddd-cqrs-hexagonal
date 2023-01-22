package com.microservices.example.common.domain.command;

public interface CommandHandler<T extends Command> {
    void handle(T command) throws Exception;
}

