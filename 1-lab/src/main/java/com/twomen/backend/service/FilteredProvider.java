package com.twomen.backend.service;

import com.twomen.backend.entity.Film;
import com.twomen.backend.persistence.BookingDAO;
import com.twomen.backend.specification.Specification;

import java.util.List;

public class FilteredProvider {
  private final BookingDAO dao;

  public FilteredProvider(BookingDAO dao) {
    this.dao = dao;
  }

  public List<Film> getFilteredData(Specification<Film> filter) {
    return dao.findAllBySpecification(filter);
  }
}
