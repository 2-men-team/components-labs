package com.twomen.backend.rest;

import com.twomen.backend.entity.*;
import com.twomen.backend.service.BookingService;
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
  //private static final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  private final BookingService service;

  @Autowired
  public BookingRestController(BookingService service) {
    this.service = service;
  }

  @GetMapping("/film-list")
  List<Film> getAllRunningFilms() {
    return service.getAllRunningFilms();
  }

  @GetMapping("/detail/{id}")
  Film getMovieShowsByFilm(@PathVariable int id) {
    return service.getFilmById(id);
  }

  @GetMapping("/film-list/{page}")
  List<Film> getPerfData(@PathVariable int page) {
    return service.getFilmsByPage(page);
  }

  /*
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
    return service.makeBooking(info, date);
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
  List<MovieShow> findAllFilms(@RequestBody SearchQuery query) {
    return service.findAllByKeyWords(query.getKeys());
  }
   */
}
