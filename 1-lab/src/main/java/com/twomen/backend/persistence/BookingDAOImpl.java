package com.twomen.backend.persistence;

import com.twomen.backend.entity.Booking;
import com.twomen.backend.entity.Film;
import com.twomen.backend.entity.MovieShow;
import com.twomen.backend.entity.Place;
import com.twomen.backend.rest.NotFoundException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import org.hibernate.query.Query;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class BookingDAOImpl implements BookingDAO {
  private static final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  private EntityManager manager;

  @Autowired
  public BookingDAOImpl(EntityManager manager) {
    this.manager = manager;
  }

  @Override
  public List<Film> getAllRunningFilms() {
    Session session = manager.unwrap(Session.class);
    Query<Film> query = session.createQuery("from Film", Film.class);
    return query.getResultList();
  }

  @Override
  public List<MovieShow> getAllRunningMovieShows() {
    Session session = manager.unwrap(Session.class);
    Query<MovieShow> query = session.createQuery("from MovieShow where is_active is true", MovieShow.class);
    return query.getResultList();
  }

  @Override
  public List<MovieShow> getMovieShowsByFilm(String film) {
    Session session = manager.unwrap(Session.class);

    Query<Film> query = session.createQuery("from Film where film_name=:film", Film.class);
    query.setParameter("film", film);
    int id = query.getSingleResult().getId(); // TODO: CHECK IF FILM EXISTS

    Query<MovieShow> movieQuery = session.createQuery("from MovieShow where film_id=:filmId", MovieShow.class);
    movieQuery.setParameter("filmId", id);

    List<MovieShow> list = movieQuery.getResultList();
    System.out.println(list);
    return list;
  }

  @Override
  public MovieShow getMovieShow(String film, Date date) {
    Session session = manager.unwrap(Session.class);

    Query<Film> query = session.createQuery("from Film where film_name=:film", Film.class);
    query.setParameter("film", film);
    int id = query.getSingleResult().getId();

    Query<MovieShow> movieQuery = session.createQuery(
      "from MovieShow where film_id=:filmId and start_time=:date", MovieShow.class);

    movieQuery.setParameter("filmId", id);
    movieQuery.setParameter("date", formatter.format(date));

    List<MovieShow> movies = movieQuery.getResultList();

    if (movies.isEmpty()) {
      return null;
    } else {
      return movies.get(0);
    }
  }

  @Override
  public MovieShow getMovieShowById(int id) {
    Session session = manager.unwrap(Session.class);
    Query<MovieShow> query = session.createQuery("from MovieShow where show_id=:id", MovieShow.class);
    query.setParameter("id", id);
    return query.getSingleResult();
  }

  @Override
  public void makeBooking(Booking info) {
    Session session = manager.unwrap(Session.class);

    List<Place> bookedPlaces = getBookedPlaces(info.getShowId());

    for (Place place : bookedPlaces) {
      if (info.getPlaces().contains(place)) {
        throw new NotFoundException("Place '" + place.getPlaceNumber() + "' for show id '" +
          + info.getShowId() + "' has already been booked.");
      }
    }

    session.save(info);
    for (Place place : info.getPlaces()) {
      place.setId(info.getId());
      session.save(place);
    }
  }

  public List<Place> getBookedPlaces(int showId) {
    Session session = manager.unwrap(Session.class);
    Query<Booking> query = session.createQuery("from Booking where show_id=:showId", Booking.class);
    query.setParameter("showId", showId);
    List<Booking> bookings = query.getResultList();

    List<Integer> ids = new ArrayList<>();
    bookings.forEach((i) -> ids.add(i.getId()));

    if (ids.isEmpty()) {
      return new ArrayList<>();
    }

    String placeQuery = "from Place where booking_id in (:ids)";
    return session.createQuery(placeQuery, Place.class).setParameterList("ids", ids).list();
  }

  @Override
  public void deleteBooking(int id) {
    Session session = manager.unwrap(Session.class);
    Query query = session.createQuery("delete from Booking where booking_id=:bookingId");
    query.setParameter("bookingId", id);
    query.executeUpdate();
  }
}
