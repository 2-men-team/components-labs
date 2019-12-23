package com.twomen.backend.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.twomen.backend.entity.Booking;
import com.twomen.backend.entity.Place;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingResolver implements GraphQLResolver<Booking> {
  public List<Place> places(Booking booking) {
    return booking.getPlaces();
  }
}
