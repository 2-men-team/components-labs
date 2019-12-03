package com.twomen.backend.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class AuthDAOFactory implements DAOFactory {
  private final EntityManager manager;

  @Autowired
  public AuthDAOFactory(EntityManager manager) {
    this.manager = manager;
  }

  @Override
  public AuthDAO create() {
    return new AuthDAOImpl(manager);
  }
}
