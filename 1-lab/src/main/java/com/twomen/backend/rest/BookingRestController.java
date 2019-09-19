package com.twomen.backend.rest;

import com.twomen.backend.entity.Booking;
import com.twomen.backend.entity.Film;
import com.twomen.backend.entity.MovieShow;
import com.twomen.backend.entity.Place;
import com.twomen.backend.service.BookingServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingRestController {
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
  MovieShow getMovieShow(@RequestParam("name") String name,
                         @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
    MovieShow show = service.getMovieShow(name, date);

    if (show == null) {
      throw new NotFoundException("Movie show not found.");
    }

    return show;
  }

  @PostMapping("/bookings")
  Booking makeBooking(
    @RequestParam String firstName,
    @RequestParam String lastName,
    @RequestParam String email,
    @RequestParam String phoneNumber,
    @RequestParam String film,
    @RequestParam List<Integer> places,
    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {

    List<Place> placeList = Place.convert(places);
    Booking.Builder builder = new Booking.Builder();

    builder
      .setFirstName(firstName)
      .setLastName(lastName)
      .setEmail(email)
      .setPhoneNumber(phoneNumber)
      .setPlaces(placeList);

    if (placeList.isEmpty()) {
      throw new NotFoundException("No places passed.");
    }

    MovieShow show = service.getMovieShow(film, date);

    if (show == null) {
      throw new NotFoundException("Movie show was not found.");
    }

    if (!show.isActive()) {
      throw new NotFoundException("Show has no free places.");
    }

    for (Integer num : places) {
      Place place = new Place(num);
      if (place.getPlaceNumber() < 0 || place.getPlaceNumber() > 90) {
        if (!show.getPlaces().contains(place)) {
          throw new NotFoundException("Asked place " + place + " is not available.");
        }
      }
    }

    Booking info = builder
      .setShowId(show.getId())
      .build();

    service.makeBooking(info);

    return info;
  }

  @GetMapping("/bookings/{phone}")
  List<Booking> getBookings(@PathVariable String phone) {
    return service.getBookingByPhone(phone);
  }

  @DeleteMapping("/bookings/{id}")
  String deleteBooking(@PathVariable int id) {
    service.deleteBooking(id);
    return "Delete booking " + id;
  }

  @PostMapping("/films")
  List<Film> findAllFilms(@RequestParam("keys") List<String> keyWords) {
    return service.findAllByKeyWords(keyWords);
  }
}
