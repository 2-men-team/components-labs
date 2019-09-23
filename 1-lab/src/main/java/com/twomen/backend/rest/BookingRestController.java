package com.twomen.backend.rest;

import com.twomen.backend.entity.*;
import com.twomen.backend.service.BookingServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BookingRestController {
  private static final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  private final BookingServiceFacade service;

  @Autowired
  public BookingRestController(BookingServiceFacade service) {
    this.service = service;
  }

  @GetMapping("/films")
  List<Film> getAllRunningFilms() {
    return service.getAllRunningFilms();
  }

  @GetMapping("/films/{filmName}")
  List<MovieShow> getMovieShowsByFilm(@PathVariable String filmName) {
    return service.getMovieShowsByFilm(filmName);
  }

  @GetMapping("/shows")
  List<MovieShow> getAllRunningMovieShows() {
    return service.getAllRunningMovieShows();
  }

  @PostMapping("/shows")
  MovieShow getMovieShow(@RequestBody Map<String, String> keys) throws ParseException {
    String name = keys.get("name");
    Date date = formatter.parse(keys.get("date"));
    return service.getMovieShow(name, date);
  }

  @PostMapping("/bookings/{date}")
  Booking makeBooking(@RequestBody BookingDTO info, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
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

    MovieShow show = service.getMovieShow(info.getFilm(), date);

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

    service.makeBooking(booking);
    return booking;
  }

  @GetMapping("/bookings/{phone}")
  List<Booking> getBookings(@PathVariable String phone) {
    return service.getBookingByPhone(phone);
  }

  @DeleteMapping("/bookings/{id}")
  String deleteBooking(@PathVariable int id) {
    service.deleteBooking(id);
    return "Query executed.";
  }

  @PostMapping("/films")
  List<Film> findAllFilms(@RequestBody SearchQuery query) {
    return service.findAllByKeyWords(query.getKeys());
  }
}
