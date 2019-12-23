package com.twomen.backend.persistence;

import com.twomen.backend.entity.Booking;
import com.twomen.backend.entity.MovieShow;
import com.twomen.backend.entity.Place;

import java.util.Date;
import java.util.List;

public interface BookingDAO {
  List<MovieShow> getAllRunningMovieShows();

  List<Place> getBookedPlaces(int showId);

  MovieShow getMovieShow(int id, Date date);

  Booking makeBooking(Booking booking);

  void deleteBooking(int id);

  Booking getBooking(int id);
}
