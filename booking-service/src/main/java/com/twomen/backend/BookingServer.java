package com.twomen.backend;

import com.twomen.backend.booking.*;
import com.twomen.backend.entity.Booking;
import com.twomen.backend.entity.MovieShow;
import com.twomen.backend.entity.Place;
import com.twomen.backend.persistence.BookingDAO;
import com.twomen.backend.persistence.BookingDAOImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class BookingServer {
  private final int port;
  private final Server server;

  public BookingServer(int port) throws IOException {
    this(ServerBuilder.forPort(port), port, new BookingDAOImpl());
  }

  public BookingServer(ServerBuilder<?> serverBuilder, int port, BookingDAO dao) {
    this.port = port;
    this.server = serverBuilder.addService(new BookingService(dao)).build();
  }

  public void start() throws IOException {
    server.start();
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      // Use stderr here since the logger may have been reset by its JVM shutdown hook.
      System.err.println("*** shutting down gRPC server since JVM is shutting down");
      BookingServer.this.stop();
      System.err.println("*** server shut down");
    }));
  }

  /** Stop serving requests and shutdown resources. */
  public void stop() {
    if (server != null) {
      server.shutdown();
    }
  }

  /**
   * Await termination on the main thread since the grpc library uses daemon threads.
   */
  private void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  /**
   * Main method.  This comment makes the linter happy.
   */
  public static void main(String[] args) throws Exception {
    BookingServer server = new BookingServer(9093);
    server.start();
    server.blockUntilShutdown();
  }

  private static List<Integer> toPlaceNums(List<Place> places) {
    return places.stream()
      .map(Place::getPlaceNumber)
      .collect(Collectors.toList());
  }

  private static List<Place> toPlaces(List<Integer> placeNums) {
    return placeNums.stream()
      .map(Place::new)
      .collect(Collectors.toList());
  }

  private static List<ShowResponse> toShowMessage(List<MovieShow> movies) {
    List<ShowResponse> result = new ArrayList<>();
    for (MovieShow movie : movies) {
      result.add(toShowMessage(movie));
    }
    return result;
  }

  private static ShowResponse toShowMessage(MovieShow movie) {
    return ShowResponse.newBuilder()
      .setShowId(movie.getId())
      .setPrice(movie.getPrice())
      .setStartTime(movie.getStartTime().getTime())
      .addAllPlaces(toPlaceNums(movie.getPlaces()))
      .setFilmId(movie.getFilmId())
      .setEndTime(movie.getEndTime().getTime())
      .build();
  }

  private static class BookingService extends BookingServiceGrpc.BookingServiceImplBase {
    private final BookingDAO dao;

    BookingService(BookingDAO dao) {
      this.dao = dao;
    }

    @Override
    public void getBooking(BookingRequest request, StreamObserver<BookingResponse> responseObserver) {
      Booking booking = dao.getBooking(request.getId());
      responseObserver.onNext(fromBooking(booking));
      responseObserver.onCompleted();
    }

    @Override
    public void getAllShows(Filter request, StreamObserver<ShowResponse> responseObserver) {
      List<ShowResponse> shows = toShowMessage(dao.getAllRunningMovieShows());
      System.err.println("SHOWS SIZE: " + shows.size());
      for (ShowResponse show : shows)
        responseObserver.onNext(show);
      responseObserver.onCompleted();
    }

    @Override
    public void getShow(ShowRequest request, StreamObserver<ShowResponse> responseObserver) {
      ShowResponse show = toShowMessage(dao.getMovieShow(request.getId(), new Date(request.getStartTime())));
      responseObserver.onNext(show);
      responseObserver.onCompleted();
    }

    @Override
    public void deleteBooking(DeleteRequest request, StreamObserver<DeleteResponse> responseObserver) {
      dao.deleteBooking(request.getId());
      responseObserver.onNext(DeleteResponse.newBuilder().setMes("Delete executed.").build());
      responseObserver.onCompleted();
    }

    @Override
    public void makeBooking(BookingRequest request, StreamObserver<BookingResponse> responseObserver) {
      Booking booking = dao.makeBooking(toBooking(request));
      responseObserver.onNext(fromBooking(booking));
      responseObserver.onCompleted();
    }

    private Booking toBooking(BookingRequest request) {
      return new Booking.Builder()
        .setEmail(request.getEmail())
        .setFirstName(request.getFirstName())
        .setLastName(request.getLastName())
        .setPhoneNumber(request.getPhoneNumber())
        .setPlaces(toPlaces(request.getPlacesList()))
        .setShowId(request.getId())
        .build();
    }

    private static BookingResponse fromBooking(Booking booking) {
      return BookingResponse.newBuilder()
        .setEmail(booking.getEmail())
        .setFirstName(booking.getFirstName())
        .setLastName(booking.getLastName())
        .setPhoneNumber(booking.getPhoneNumber())
        .addAllPlaces(toPlaceNums(booking.getPlaces()))
        .setMes("Booking")
        .build();
    }

    /*
    @Override
    public void getAllShows(Filter request, StreamObserver<ShowResponse> responseObserver) {
      List<Show> shows = dao.getAllRunningMovieShows();
      for (Show show : shows) {
        responseObserver.onNext(show);
      }
      responseObserver.onCompleted();
    }

    @Override
    public void getShow(ShowRequest request, StreamObserver<ShowResponse> responseObserver) {
      super.getShow(request, responseObserver);
    }

    @Override
    public void deleteBooking(DeleteRequest request, StreamObserver<DeleteResponse> responseObserver) {
      super.deleteBooking(request, responseObserver);
    }

    @Override
    public void makeBooking(BookingRequest request, StreamObserver<BookingResponse> responseObserver) {
      super.makeBooking(request, responseObserver);
    }

    @Override
    public void getAllShows(Filter request, StreamObserver<Show> responseObserver) {
      List<Show> shows = dao.getAllRunningMovieShows();
      for (Show show : shows) {
        responseObserver.onNext(show);
      }
      responseObserver.onCompleted();
    }

    @Override
    public void getShow(ShowRequest request, StreamObserver<Show> responseObserver) {
      Show show = dao.getMovieShow(request.getFilmName(), new Date(request.getStartTime()));
      responseObserver.onNext(show);
      responseObserver.onCompleted();
    }

    @Override
    public void deleteBooking(DeleteRequest request, StreamObserver<DeleteMessage> responseObserver) {
      String message = dao.deleteBooking(request);
      responseObserver.onNext(DeleteMessage.newBuilder().setMes(message).build());
      responseObserver.onCompleted();
    }

    @Override
    public void makeBooking(Booking request, StreamObserver<Booking> responseObserver) {
      Booking booking = dao.makeBooking(request);
      responseObserver.onNext(booking);
      responseObserver.onCompleted();
    }

     */
  }
}
