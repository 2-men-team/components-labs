package com.twomen.backend.persistence;

import com.twomen.backend.Config;
import com.twomen.backend.booking.*;
import com.twomen.backend.entity.Booking;
import com.twomen.backend.entity.BookingDTO;
import com.twomen.backend.entity.MovieShow;
import com.twomen.backend.entity.Place;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.twomen.backend.booking.BookingServiceGrpc.*;

@Repository
public class BookingProvider {
  private static final String HOST = Config.HOST_IP;
  private static final int PORT = 9093;

  private final ManagedChannel channel;
  private final BookingServiceBlockingStub blockingStub;

  public BookingProvider() {
    this(ManagedChannelBuilder.forAddress(HOST, PORT).usePlaintext());
  }

  public BookingProvider(ManagedChannelBuilder<?> channelBuilder) {
    channel = channelBuilder.build();
    blockingStub = BookingServiceGrpc.newBlockingStub(channel);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  // interface
  public List<MovieShow> getAllRunningMovieShows() {
    Iterator<ShowResponse> showResponses = getAllShows();
    List<MovieShow> list = new ArrayList<>();
    while (showResponses.hasNext())
      list.add(MovieShow.of(showResponses.next()));
    return list;
  }

  public MovieShow getMovieShow(int id, Date date) {
    ShowRequest request = ShowRequest.newBuilder().setId(id).setStartTime(date.getTime()).build();
    return MovieShow.of(getShow(request));
  }

  public Booking makeBooking(Booking booking) {
    BookingRequest request = BookingRequest.newBuilder()
      .setEmail(booking.getEmail())
      .setFirstName(booking.getFirstName())
      .setLastName(booking.getLastName())
      .setPhoneNumber(booking.getPhoneNumber())
      .addAllPlaces(toPlaceNums(booking.getPlaces()))
      .setId(booking.getShowId())
      .build();

    BookingResponse response = makeBooking(request);
    return Booking.of(response);
  }

  public void deleteBooking(int id) {
    blockingStub.deleteBooking(DeleteRequest.newBuilder().setId(id).build());
  }

  // grpc calls
  private Iterator<ShowResponse> getAllShows() {
    return blockingStub.getAllShows(Filter.newBuilder().build());
  }

  public ShowResponse getShow(ShowRequest request) {
    return blockingStub.getShow(request);
  }

  public DeleteResponse deleteBooking(DeleteRequest request) {
    return blockingStub.deleteBooking(request);
  }

  public BookingResponse makeBooking(BookingRequest request) {
    return blockingStub.makeBooking(request);
  }

  public static List<Integer> toPlaceNums(List<Place> places) {
    return places.stream()
      .map(Place::getPlaceNumber)
      .collect(Collectors.toList());
  }

  public static List<Place> toPlaces(List<Integer> placeNums) {
    return placeNums.stream()
      .map(Place::new)
      .collect(Collectors.toList());
  }
}
