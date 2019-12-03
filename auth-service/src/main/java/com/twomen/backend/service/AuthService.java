package com.twomen.backend.service;

import com.twomen.backend.entity.*;

public interface AuthService {
  AuthData registerUser(AuthData data);
  boolean isValid(String apiKey);
}
