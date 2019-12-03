package com.twomen.backend.persistence;

import com.twomen.backend.entity.AuthData;

public interface AuthDAO {
  boolean exists(AuthData user);
  AuthData registerUser(AuthData data);
  boolean isValid(String apiKey);
}
