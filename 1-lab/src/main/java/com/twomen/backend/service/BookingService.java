package com.twomen.backend.service;

import com.twomen.backend.entity.Booking;
import com.twomen.backend.entity.Film;
import com.twomen.backend.entity.MovieShow;

import java.util.Date;
import java.util.List;

public interface BookingService {
  List<Film> getAllRunningFilms();
  List<MovieShow> getAllRunningMovieShows();
  List<MovieShow> getMovieShowsByFilm(String film);
  MovieShow getMovieShowById(int id);
  MovieShow getMovieShow(String name, Date date); // pass parameters with JSON?
  void makeBooking(Booking info);
  void deleteBooking(int id);
}
