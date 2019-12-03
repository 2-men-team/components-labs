package com.twomen.backend.service;

import com.twomen.backend.entity.*;
import com.twomen.backend.specification.Specification;

import java.util.Date;
import java.util.List;

public interface BookingService {
  List<Film> getAllRunningFilms();

  List<MovieShow> getAllRunningMovieShows();

  MovieShow getMovieShow(String name, Date date); // pass parameters with JSON?

  Booking makeBooking(BookingDTO info, Date date);

  void deleteBooking(int id);

  List<Film> findAllByKeyWords(List<String> keyWords);

  List<Film> findAllByKeyWordsPerf(List<String> keys);

  List<Film> getFilmsByPage(int page);

  void validate(String apiKey);
}
