package com.microservices.example.common.infrastructure.query;

import com.microservices.example.common.domain.query.Query;
import com.microservices.example.common.domain.query.QueryBus;
import com.microservices.example.common.domain.query.QueryHandler;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Primary
public class SpringQueryBus implements QueryBus {
    private Map<Class, QueryHandler> handlers;

    public SpringQueryBus(List<QueryHandler> queryHandlerImplementations) {
        this.handlers = new HashMap<>();
        queryHandlerImplementations.forEach(queryHandler -> {
            Class queryClass = getQueryClass(queryHandler);
            handlers.put(queryClass, queryHandler);
        });
    }

    @Override
    public <T> T handle(Query query) throws Exception {
        if (!handlers.containsKey(query.getClass())) {
            throw new Exception(
                    String.format("No handler for %s", query.getClass().getName())
            );
        }
        return (T) handlers.get(query.getClass()).handle(query);
    }

    private Class<?> getQueryClass(QueryHandler handler) {
        Type commandInterface = ((ParameterizedType) handler
                .getClass()
                .getGenericInterfaces()[0])
                .getActualTypeArguments()[1];
        return getClass(commandInterface.getTypeName());
    }

    private Class<?> getClass(String name) {
        try {
            return Class.forName(name);
        } catch (Exception e) {
            return null;
        }
    }
}
