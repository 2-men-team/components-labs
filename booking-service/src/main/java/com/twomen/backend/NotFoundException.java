package com.twomen.backend;

public class NotFoundException extends RuntimeException {
  public NotFoundException() {
    super();
  }

  public NotFoundException(String mesage) {
    super(mesage);
  }

  public NotFoundException(Throwable throwable) {
    super(throwable);
  }

  public NotFoundException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
