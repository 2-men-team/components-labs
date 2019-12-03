package com.twomen.backend.persistence;

import com.twomen.backend.entity.Film;
import com.twomen.backend.specification.Specification;

import java.util.List;

public interface BookingDAO {
  List<Film> getAllRunningFilms();

  <T> List<T> findAllBySpecification(Specification<T> specification);

  Film getFilmById(int id);

  Film getFilmByName(String name);
}
