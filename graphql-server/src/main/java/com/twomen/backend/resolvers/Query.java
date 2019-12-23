package com.twomen.backend.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.twomen.backend.entity.Booking;
import com.twomen.backend.entity.Film;
import com.twomen.backend.entity.MovieShow;
import com.twomen.backend.entity.Place;
import com.twomen.backend.service.BookingService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
  private final BookingService service;

  @Autowired
  public Query(BookingService service) {
    this.service = service;
  }

  public List<Place> getPlaces(DataFetchingEnvironment env) {
    Booking booking = env.getSource();
    return booking.getPlaces();
  }

  public Booking getBooking(int id) {
    Booking booking = service.getBooking(id);
    System.out.println(booking.getPlaces());
    return booking;
  }

  public List<MovieShow> getAllMovieShows() {
    return service.getAllRunningMovieShows();
  }

  public List<Film> findAllByKeyWords(List<String> keys) {
    return service.findAllByKeyWords(keys);
  }
}
