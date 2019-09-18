package com.twomen.backend.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
  @ExceptionHandler
  public ResponseEntity<BookingErrorResponse> handleException(NotFoundException e) {
    BookingErrorResponse error = new BookingErrorResponse(
      HttpStatus.NOT_FOUND.value(),
      e.getMessage(),
      System.currentTimeMillis()
    );

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler
  public ResponseEntity<BookingErrorResponse> handleException(Exception e) {
    BookingErrorResponse error = new BookingErrorResponse(
      HttpStatus.BAD_REQUEST.value(),
      e.getMessage(),
      System.currentTimeMillis()
    );

    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }
}
