package com.microservices.example.common.domain.query;

public interface QueryHandler<T, U extends Query> {
    T handle(U query) throws Exception;
}
