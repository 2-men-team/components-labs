package com.twomen.backend.persistence;

import com.twomen.backend.entity.Film;

import java.util.List;

public interface DataProvider {
  List<Film> getAllFilms();
  List<Film> getFilmsByKeyWords(List<String> keyWords);
}
