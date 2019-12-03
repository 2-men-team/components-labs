package com.twomen.backend.rest;

public class BookingAuthenticationException extends RuntimeException {
  public BookingAuthenticationException() {
    super();
  }

  public BookingAuthenticationException(String message) {
    super(message);
  }

  public BookingAuthenticationException(String message, Throwable cause) {
    super(message, cause);
  }

  public BookingAuthenticationException(Throwable cause) {
    super(cause);
  }
}
