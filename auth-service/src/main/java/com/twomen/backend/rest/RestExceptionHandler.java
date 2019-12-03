package com.twomen.backend.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
  @ExceptionHandler
  public ResponseEntity<AuthErrorResponse> handleException(NotFoundException e) {
    AuthErrorResponse error = new AuthErrorResponse(
      HttpStatus.NOT_FOUND.value(),
      e.getMessage(),
      System.currentTimeMillis()
    );

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler
  public ResponseEntity<AuthErrorResponse> handleException(Exception e) {
    AuthErrorResponse error = new AuthErrorResponse(
      HttpStatus.BAD_REQUEST.value(),
      e.getMessage(),
      System.currentTimeMillis()
    );

    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }
}
