package com.twomen.backend.persistence;

import com.twomen.backend.specification.Specification;

import java.util.List;

public interface BookingDAO {
  <T> List<T> findAllBySpecification(Specification<T> specification);
  //List<Film> getAllRunningFilms();
  //List<MovieShow> getAllRunningMovieShows();
  //List<MovieShow> getMovieShowsByFilm(String film);
  //MovieShow getMovieShowById(int id);
  //List<Place> getBookedPlaces(int showId);
  //List<Booking> getBookingByPhone(String phone);
  //MovieShow getMovieShow(String name, Date date); // pass parameters with JSON?
  //void makeBooking(Booking info);
  //void deleteBooking(int id);
}
