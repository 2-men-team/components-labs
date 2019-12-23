package com.twomen.backend.service;

import com.twomen.backend.entity.*;
import com.twomen.backend.persistence.*;
import com.twomen.backend.rest.BookingAuthenticationException;
import com.twomen.backend.rest.NotFoundException;
import com.twomen.backend.specification.MatchesKeyWords;
import com.twomen.backend.specification.Specification;
import com.twomen.backend.util.Cache;
import com.twomen.backend.util.TimedHashCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.Period;
import java.util.*;

@Service
public class BookingServiceImpl implements BookingService {
  private static final int FILTERED_ID = 1;
  private static final int NONFILTERED_ID = 2;

  private final BookingDAO dao;
  private final FilteredProvider filteredProvider;
  private final NonFilteredProvider nonFilteredProvider;
  private final AuthProvider authProvider;
  private final BookingProvider bookingProvider;

  //private final Cache<String, Set<Film>> filteredCache = new TimedHashCache<>(Period.ofDays(1));
  //private final Cache<String, Set<Film>> nonFilteredCache = new TimedHashCache<>(Period.ofDays(1));

  @Autowired
  public BookingServiceImpl(DAOFactory factory,
                            FilteredProvider filteredProvider,
                            NonFilteredProvider nonFilteredProvider,
                            AuthProvider authProvider,
                            BookingProvider bookingProvider) {
    this.dao = factory.create();
    this.filteredProvider = filteredProvider;
    this.nonFilteredProvider = nonFilteredProvider;
    this.authProvider = authProvider;
    this.bookingProvider = bookingProvider;
  }

  public void validate(String apiKey) {
    if (!authProvider.isValid(apiKey)) {
      throw new BookingAuthenticationException();
    }
  }

  /*@PostConstruct
  private void initializeCaches() {
    List<Film> nonFilteredData = nonFilteredProvider.getAllFilms();
    List<String> keys = new ArrayList<>();

    for (int i = 1; i <= 500; ++i) {
      keys.add("" + i);
    }

    List<Film> filteredData = findAllByKeyWords(keys);
    addToCache(keys, filteredData, filteredCache);
    addToCache(keys, nonFilteredData, nonFilteredCache);
  }*/

  @Override
  @Transactional
  public List<Film> getAllRunningFilms() {
    List<Film> films = nonFilteredProvider.getAllFilms();
    films.addAll(dao.getAllRunningFilms());
    return films;
  }

  @Cacheable(value = "findAllByKeyWords", key = "keyWords.toString()")
  @Override
  public List<Film> findAllByKeyWords(List<String> keyWords) {
    Specification<Film> specification = new MatchesKeyWords(keyWords);
    List<Film> films = dao.findAllBySpecification(specification);
    films.addAll(filteredProvider.getFilmsByKeyWords(keyWords));
    return films;
  }

  /*@Override
  public List<Film> findAllByKeyWordsPerf(List<String> keyWords) {
    long time = System.currentTimeMillis();
    Set<Film> result = new HashSet<>();
    List<String> filteredRequest = new ArrayList<>();
    boolean nonFilteredRequest = false;

    for (String key : keyWords) {
      Set<Film> filteredData = filteredCache.get(key);
      Set<Film> nonFilteredData = nonFilteredCache.get(key);

      if (filteredData == null) {
        filteredRequest.add(key);
      } else {
        result.addAll(filteredData);
      }

      if (nonFilteredData == null) {
        nonFilteredRequest = true;
      }
    }

    if (!filteredRequest.isEmpty()) {
      List<Film> response = findAllByKeyWords(keyWords);
      addToCache(filteredRequest, response, filteredCache);
      result.addAll(response);
    }

    if (nonFilteredRequest) {
      List<Film> response = nonFilteredProvider.getAllFilms();
      Set<Film> nonFilteredResult = addToCache(keyWords, response, nonFilteredCache);
      result.addAll(nonFilteredResult);
    }

    System.out.println("Response time (s): " + (System.currentTimeMillis() - time) / 1000);
    return new ArrayList<>(result);
  }

  private Set<Film> addToCache(List<String> request, List<Film> response, Cache<String, Set<Film>> cache) {
    Set<Film> result = new HashSet<>();

    for (String key : request) {
      Specification<Film> spec = new MatchesKeyWords(Collections.singletonList(key));
      Set<Film> set = new HashSet<>();

      for (Film film : response) {
        if (spec.isSatisfiedBy(film)) {
          set.add(film);
          result.add(film);
        }
      }

      if (!cache.containsKey(key)) {
        cache.put(key, set);
      } else {
        cache.get(key).addAll(set);
      }
    }

    return result;
  }*/

  @Override
  public List<Film> getFilmsByPage(int page) {
    return nonFilteredProvider.getFilmsForPage(page);
  }

  @Override
  @Transactional
  public List<MovieShow> getAllRunningMovieShows() {
    List<MovieShow> shows = bookingProvider.getAllRunningMovieShows();
    for (MovieShow show : shows) {
      System.out.println(show.getFilmId());
      show.setFilm(dao.getFilmById(show.getFilmId()));
    }
    return shows;
  }

  @Override
  @Transactional
  public MovieShow getMovieShow(String name, Date date) {
    MovieShow show = bookingProvider.getMovieShow(dao.getFilmByName(name).getId(), date);
    show.setFilm(dao.getFilmById(show.getFilmId()));
    return show;
  }

  @Override
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

    MovieShow show = bookingProvider.getMovieShow(dao.getFilmByName(info.getFilm()).getId(), date);

    System.out.println("RECEIVED show:" + show.getFilmId());
    for (Place place : placeList) {
      if (place.getPlaceNumber() < 0 || place.getPlaceNumber() > 90) {
        if (!show.getPlaces().contains(place)) {
          throw new NotFoundException("Asked place " + place + " is not available.");
        }
      }
    }

    System.out.println(show.getId());
    Booking booking = builder
      .setShowId(show.getId())
      .build();

    bookingProvider.makeBooking(booking);
    return booking;
  }

  @Override
  public Booking getBooking(int id) {
    return bookingProvider.getBooking(id);
  }

  @Override
  public void deleteBooking(int id) {
    bookingProvider.deleteBooking(id);
  }
}
