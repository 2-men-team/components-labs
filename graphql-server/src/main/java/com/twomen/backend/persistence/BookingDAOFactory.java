package com.twomen.backend.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class BookingDAOFactory implements DAOFactory {
  private final EntityManager manager;

  @Autowired
  public BookingDAOFactory(EntityManager manager) {
    this.manager = manager;
  }

  @Override
  public BookingDAO create() {
    return new BookingDAOImpl(manager);
  }
}
