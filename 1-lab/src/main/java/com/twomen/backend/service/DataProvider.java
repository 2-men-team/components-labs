package com.twomen.backend.service;

public interface DataProvider<U, T> {
  T getData(U filter);
}
