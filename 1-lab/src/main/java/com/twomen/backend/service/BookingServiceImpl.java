package com.twomen.backend.service;

import com.twomen.backend.entity.*;
import com.twomen.backend.persistence.BookingDAO;
import com.twomen.backend.persistence.DAOFactory;
import com.twomen.backend.persistence.FilteredProvider;
import com.twomen.backend.persistence.NonFilteredProvider;
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
  private static final int FILTERED_ID = 1;
  private static final int NONFILTERED_ID = 2;

  private final BookingDAO dao;
  private final FilteredProvider filteredProvider;
  private final NonFilteredProvider nonFilteredProvider;

  @Autowired
  public BookingServiceImpl(DAOFactory factory,
                            FilteredProvider filteredProvider,
                            NonFilteredProvider nonFilteredProvider) {
    this.dao = factory.create();
    this.filteredProvider = filteredProvider;
    this.nonFilteredProvider = nonFilteredProvider;
  }

  @Override
  @Transactional
  public List<Film> getAllRunningFilms() {
    List<Film> films = nonFilteredProvider.getAllFilms();
    films.addAll(dao.getAllRunningFilms());
    return films;
  }

  @Override
  public List<Film> findAllByKeyWords(List<String> keyWords) {
    Specification<Film> specification = new MatchesKeyWords(keyWords);
    List<Film> films = dao.findAllBySpecification(specification);
    films.addAll(filteredProvider.getFilmsByKeyWords(keyWords));
    return films;
  }

  @Override
  public List<Film> findAllByKeyWordsPerf(List<String> keyWords) {
    Specification<Film> specification = new MatchesKeyWords(keyWords);
    List<Film> films = dao.findAllBySpecification(specification);
    films.addAll(filteredProvider.getFilmsByKeyWordsCached(keyWords));
    return films;
  }

  @Override
  public List<Film> getFilmsByPage(int page) {
    return nonFilteredProvider.getFilmsForPage(page);
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
}
