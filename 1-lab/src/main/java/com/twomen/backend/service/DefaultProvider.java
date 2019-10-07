package com.twomen.backend.service;

import com.twomen.backend.entity.Film;
import com.twomen.backend.entity.MovieShow;
import com.twomen.backend.persistence.BookingDAO;

import java.util.List;

public class DefaultProvider {
  private final BookingDAO dao;

  public DefaultProvider(BookingDAO dao) {
    this.dao = dao;
  }

  public List<MovieShow> getDataByName(String name) {
    return dao.getMovieShowsByFilm(name);
  }

  public List<Film> getAllData() {
    return dao.getAllRunningFilms();
  }
}
