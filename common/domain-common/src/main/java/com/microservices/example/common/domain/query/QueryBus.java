package com.microservices.example.common.domain.query;

public interface QueryBus  {
    <T> T handle(Query query) throws Exception;
}
