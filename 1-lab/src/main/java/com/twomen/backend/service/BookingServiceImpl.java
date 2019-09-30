package com.twomen.backend.service;

import com.twomen.backend.entity.*;
import com.twomen.backend.persistence.BookingDAO;
import com.twomen.backend.persistence.DAOFactory;
import com.twomen.backend.rest.NotFoundException;
import com.twomen.backend.specification.MatchesKeyWords;
import com.twomen.backend.specification.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
  private final BookingDAO dao;

  @Autowired
  public BookingServiceImpl(DAOFactory factory) {
    this.dao = factory.create();
  }

  @Override
  @Transactional
  public List<Film> getAllRunningFilms() {
    return dao.getAllRunningFilms();
  }

  @Override
  @Transactional
  public List<MovieShow> getAllRunningMovieShows() {
    return dao.getAllRunningMovieShows();
  }

  @Override
  @Transactional
  public List<MovieShow> getMovieShowsByFilm(String film) {
    return dao.getMovieShowsByFilm(film);
  }

  @Override
  @Transactional
  public MovieShow getMovieShow(String name, Date date) {
    return dao.getMovieShow(name, date);
  }

  @Override
  @Transactional
  public Booking makeBooking(BookingDTO info, Date date) {
    List<Place> placeList = Place.convert(info.getPlaces());
    Booking.Builder builder = new Booking.Builder();

    builder
      .setFilmName(info.getFilm())
      .setFirstName(info.getFirstName())
      .setLastName(info.getLastName())
      .setEmail(info.getEmail())
      .setPhoneNumber(info.getPhoneNumber())
      .setPlaces(placeList);

    if (placeList.isEmpty()) {
      throw new NotFoundException("No places passed.");
    }

    MovieShow show = getMovieShow(info.getFilm(), date);

    if (!show.isActive()) {
      throw new NotFoundException("Show is no longer active.");
    }

    for (Place place : placeList) {
      if (place.getPlaceNumber() < 0 || place.getPlaceNumber() > 90) {
        if (!show.getPlaces().contains(place)) {
          throw new NotFoundException("Asked place " + place + " is not available.");
        }
      }
    }

    Booking booking = builder
      .setShowId(show.getId())
      .build();

    booking.setId(0);
    dao.makeBooking(booking);
    return booking;
  }

  @Override
  @Transactional
  public List<Booking> getBookingByPhone(String phone) {
    return dao.getBookingByPhone(phone);
  }

  @Override
  @Transactional
  public void deleteBooking(int id) {
    dao.deleteBooking(id);
  }

  @Override
  public List<Film> findAllByKeyWords(List<String> keyWords) {
    Specification<Film> specification = new MatchesKeyWords(keyWords);
    return dao.findAllBySpecification(specification);
  }
}
