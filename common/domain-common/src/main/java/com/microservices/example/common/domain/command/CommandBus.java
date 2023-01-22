package com.microservices.example.common.domain.command;

public interface CommandBus {
    void dispatch(Command command) throws Exception;
}
