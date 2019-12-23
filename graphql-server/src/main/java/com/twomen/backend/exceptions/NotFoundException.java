package com.twomen.backend.exceptions;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotFoundException extends RuntimeException implements GraphQLError {
  private Map<String, Object> errors = new HashMap<>();

  public NotFoundException(String message) {
    super(message);
    errors.put("NotFoundException", message);
  }

  @Override
  public Map<String, Object> getExtensions() {
    return errors;
  }

  @Override
  public List<SourceLocation> getLocations() {
    return null;
  }

  @Override
  public ErrorType getErrorType() {
    return ErrorType.DataFetchingException;
  }
}
