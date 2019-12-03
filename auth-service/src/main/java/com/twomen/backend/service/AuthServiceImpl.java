package com.twomen.backend.service;

import com.twomen.backend.entity.*;
import com.twomen.backend.persistence.AuthDAO;
import com.twomen.backend.persistence.DAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

@Service
public class AuthServiceImpl implements AuthService {
  private final AuthDAO dao;

  @Autowired
  public AuthServiceImpl(DAOFactory factory) {
    this.dao = factory.create();
  }

  @Override
  @Transactional
  public AuthData registerUser(AuthData user) {
    if (dao.exists(user))
      throw new RuntimeException("The user with email '" + user.getEmail() + "' already exists.");
    user.setApiKey(generateApiKey());
    return dao.registerUser(user);
  }

  @Override
  @Transactional
  public boolean isValid(String apiKey) {
    return dao.isValid(apiKey);
  }

  private String generateApiKey() {
    while (true) {
      String key = generateRandomKey();
      if (!isValid(key)) {
        return key;
      }
    }
  }

  private String generateRandomKey() {
    int left = 97, right = 122, len = 16;
    Random random = new Random();
    StringBuilder buffer = new StringBuilder(len);
    for (int i = 0; i < len; i++) {
      int randomInt = left + (int)
        (random.nextFloat() * (right - left + 1));
      buffer.append((char) randomInt);
    }

    return buffer.toString();
  }
}
