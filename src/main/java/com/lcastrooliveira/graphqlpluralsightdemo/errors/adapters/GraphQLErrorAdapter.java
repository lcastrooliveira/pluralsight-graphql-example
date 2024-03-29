package com.lcastrooliveira.graphqlpluralsightdemo.errors.adapters;

import graphql.ErrorType;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;
import java.util.Map;

public class GraphQLErrorAdapter implements GraphQLError {

    private final GraphQLError error;

    public GraphQLErrorAdapter(GraphQLError error) {
        this.error = error;
    }

    @Override
    public String getMessage() {
        if(error instanceof ExceptionWhileDataFetching) {
            return ((ExceptionWhileDataFetching)error).getException().getMessage();
        } else {
            return error.getMessage();
        }
    }

    @Override
    public List<SourceLocation> getLocations() {
        return error.getLocations();
    }

    @Override
    public ErrorType getErrorType() {
        return error.getErrorType();
    }

    @Override
    public Map<String, Object> getExtensions() {
        return error.getExtensions();
    }

    @Override
    public List<Object> getPath() {
        return error.getPath();
    }

    @Override
    public Map<String, Object> toSpecification() {
        return error.toSpecification();
    }
}
