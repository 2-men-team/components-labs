package com.twomen.backend.service;

import com.twomen.backend.entity.Booking;
import com.twomen.backend.entity.BookingDTO;
import com.twomen.backend.entity.Film;
import com.twomen.backend.entity.MovieShow;
import com.twomen.backend.specification.Specification;

import java.util.Date;
import java.util.List;

public interface BookingService {
  List<Film> getAllRunningFilms();
  List<MovieShow> getAllRunningMovieShows();
  List<MovieShow> getMovieShowsByFilm(String film);
  MovieShow getMovieShow(String name, Date date); // pass parameters with JSON?
  Booking makeBooking(BookingDTO info, Date date);
  List<Booking> getBookingByPhone(String phone);
  void deleteBooking(int id);
  List<Film> findAllByKeyWords(List<String> keyWords);
}
