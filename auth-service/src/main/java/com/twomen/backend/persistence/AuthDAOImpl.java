package com.twomen.backend.persistence;

import com.twomen.backend.entity.AuthData;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;

public class AuthDAOImpl implements AuthDAO {
  private EntityManager manager;

  public AuthDAOImpl(EntityManager manager) {
    this.manager = manager;
  }

  @Override
  public AuthData registerUser(AuthData user) {
    Session session = manager.unwrap(Session.class);
    session.save(user);
    return user;
  }

  @Override
  public boolean exists(AuthData user) {
    Session session = manager.unwrap(Session.class);
    Query<AuthData> query = session.createQuery("from AuthData where api_key=:apiKey", AuthData.class);
    query.setParameter("apiKey", user.getApiKey());
    return !query.getResultList().isEmpty();
  }

  @Override
  public boolean isValid(String apiKey) {
    Session session = manager.unwrap(Session.class);
    Query<AuthData> query = session.createQuery("from AuthData where api_key=:apiKey", AuthData.class);
    query.setParameter("apiKey", apiKey);
    return !query.getResultList().isEmpty();
  }
}
