package com.twomen.backend.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.twomen.backend.entity.Booking;
import com.twomen.backend.entity.BookingDTO;
import com.twomen.backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class Mutation implements GraphQLMutationResolver {
  private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  private final BookingService service;

  @Autowired
  public Mutation(BookingService service) {
    this.service = service;
  }

  public Booking makeBooking(String film,
                             String firstName,
                             String lastName,
                             String email,
                             String phoneNumber,
                             List<Integer> places,
                             String date) throws ParseException {
    BookingDTO dto = BookingDTO.builder()
      .setFilm(film)
      .setFirstName(firstName)
      .setLastName(lastName)
      .setEmail(email)
      .setPhoneNumber(phoneNumber)
      .setPlaces(places)
      .build();

    return service.makeBooking(dto, formatter.parse(date));
  }

  public Boolean deleteBooking(int id) {
    service.deleteBooking(id);
    return null;
  }
}
