package com.twomen.backend.rest;

import com.twomen.backend.entity.*;
import com.twomen.backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingRestController {
  private static final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  private final BookingService service;

  @Autowired
  public BookingRestController(BookingService service) {
    this.service = service;
  }

  @GetMapping("/films")
  List<Film> getAllRunningFilms(@RequestParam("api_key") String apiKey) {
    service.validate(apiKey);
    return service.getAllRunningFilms();
  }

  @PostMapping("/films")
  List<Film> findAllFilms(@RequestBody SearchQuery query) {
    service.validate(query.getApiKey());
    return service.findAllByKeyWords(query.getKeys());
  }

  /*@PostMapping("/films-perf")
  List<Film> findAllFilmsPerf(@RequestBody SearchQuery query) {
    service.validate(query.getApiKey());
    return service.findAllByKeyWordsPerf(query.getKeys());
  }*/

  @GetMapping("/films/{page}")
  List<Film> getFilmsByPage(@PathVariable int page, @RequestParam("api_key") String apiKey) {
    service.validate(apiKey);
    return service.getFilmsByPage(page);
  }

  // grpc calls
  @GetMapping("/shows")
  List<MovieShow> getAllRunningMovieShows(@RequestParam("api_key") String apiKey) {
    service.validate(apiKey);
    return service.getAllRunningMovieShows();
  }

  @GetMapping("/shows/{date}")
  MovieShow getMovieShow(@RequestParam("api_key") String apiKey,
                         @RequestParam("film_name") String filmName,
                         @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
    service.validate(apiKey);
    return service.getMovieShow(filmName, date);
  }

  @PostMapping("/bookings/{date}")
  Booking makeBooking(@RequestBody BookingDTO info, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
    //service.validate(info.getApiKey());
    return service.makeBooking(info, date);
  }

  @DeleteMapping("/bookings/{id}")
  String deleteBooking(@PathVariable int id, @RequestParam("api_key") String apiKey) {
    service.validate(apiKey);
    service.deleteBooking(id);
    return "Query executed.";
  }
}
