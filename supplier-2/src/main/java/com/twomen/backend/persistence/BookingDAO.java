package com.twomen.backend.persistence;

import com.twomen.backend.entity.Booking;
import com.twomen.backend.entity.Film;
import com.twomen.backend.entity.MovieShow;
import com.twomen.backend.entity.Place;
import com.twomen.backend.specification.Specification;

import java.util.Date;
import java.util.List;

public interface BookingDAO {
  List<Film> getAllRunningFilms();
  Film getFilmById(int id);
  /*
  List<MovieShow> getAllRunningMovieShows();
  List<MovieShow> getMovieShowsByFilm(String film);
  MovieShow getMovieShowById(int id);
  <T> List<T> findAllBySpecification(Specification<T> specification);
  List<Place> getBookedPlaces(int showId);
  List<Booking> getBookingByPhone(String phone);
  MovieShow getMovieShow(String name, Date date); // pass parameters with JSON?
  void makeBooking(Booking info);
  void deleteBooking(int id);
   */
}
