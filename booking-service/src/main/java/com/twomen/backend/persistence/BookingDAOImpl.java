package com.twomen.backend.persistence;

import com.twomen.backend.NotFoundException;
import com.twomen.backend.entity.Booking;
import com.twomen.backend.entity.Film;
import com.twomen.backend.entity.MovieShow;
import com.twomen.backend.entity.Place;
import com.twomen.backend.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingDAOImpl implements BookingDAO {
  private static final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  private Session getSession() {
    return HibernateUtil.getSessionFactory().openSession();
  }

  @Override
  public List<Place> getBookedPlaces(int showId) {
    Session session = getSession();
    session.beginTransaction();

    Query<Booking> query = session.createQuery("from Booking where show_id=:showId", Booking.class);
    query.setParameter("showId", showId);
    List<Booking> bookings = query.getResultList();

    List<Integer> ids = new ArrayList<>();
    bookings.forEach((i) -> ids.add(i.getId()));

    if (ids.isEmpty())
      return new ArrayList<>();

    return session
      .createQuery("from Place where booking_id in (:ids)", Place.class)
      .setParameterList("ids", ids)
      .getResultList();
  }

  @Override
  public List<MovieShow> getAllRunningMovieShows() {
    Session session = getSession();
    Query<MovieShow> query = session.createQuery("from MovieShow", MovieShow.class);
    return query.getResultList();
  }

  @Override
  public MovieShow getMovieShow(int id, Date date) {
    Session session = getSession();

    Query<MovieShow> movieQuery = session.createQuery(
      "from MovieShow where film_id=:filmId and start_time=:date", MovieShow.class);

    movieQuery.setParameter("filmId", id);
    movieQuery.setParameter("date", formatter.format(date));
    return getSingleResult(movieQuery, "Movie show for '" + id + "' at '" + date + "' was not found.");
  }

  @Override
  public Booking getBooking(int id) {
    Session session = getSession();
    Query<Booking> query = session.createQuery("from Booking where booking_id=:id", Booking.class);
    query.setParameter("id", id);
    return getSingleResult(query, "Booking with id '" + id + "' was not found.");
  }

  @Override
  public Booking makeBooking(Booking info) {
    Session session = getSession();
    session.beginTransaction();

    List<Place> bookedPlaces = getBookedPlaces(info.getShowId());

    for (Place place : bookedPlaces) {
      if (info.getPlaces().contains(place)) {
        throw new NotFoundException("Place '" + place.getPlaceNumber() + "' for show id '" +
          + info.getShowId() + "' has already been booked.");
      }
    }

    System.err.println("PLACES:" + info.getPlaces());
    session.save(info);
    System.err.println("INSERTED: " + info);

    for (Place place : info.getPlaces()) {
      place.setId(info.getId());
      place.setShowId(info.getShowId());
      session.save(place);
    }

    session.getTransaction().commit();
    return info;
  }

  @Override
  public void deleteBooking(int id) {
    System.err.println("ID");
    Session session = getSession();
    session.beginTransaction();
    Booking booking = session.get(Booking.class, id);
    System.err.println("BOOKING OBJECT: " + booking);
    System.err.println("BOOKING ID: " + booking.getId());
    session.delete(booking);
    session.getTransaction().commit();
  }

  private int getFilmById(String filmName) {
    Session session = getSession();
    Query<Film> query = session.createQuery("from Film where film_name=:film", Film.class);
    query.setParameter("film", filmName);
    return getSingleResult(query,"No movie shows for " + filmName + "' found.").getId();
  }

  private static <T> T getSingleResult(Query<T> query, String message) {
    List<T> result = query.getResultList();
    if (result.isEmpty()) {
      throw new NotFoundException(message);
    } else {
      return result.get(0);
    }
  }

  /*
  @Override
  public List<MovieShow> getAllRunningMovieShows() {
    return null;
  }

  @Override
  public Show getMovieShow(String name, Date date) {
    return null;
  }

  @Override
  public com.twomen.backend.booking.Booking makeBooking(com.twomen.backend.booking.Booking booking) {
    return null;
  }

  @Override
  public String deleteBooking(DeleteRequest request) {
    return null;
  }

  @Override
  public List<Place> getBookedPlaces(int showId) {
    Session session = manager.unwrap(Session.class);
    Query<Booking> query = session.createQuery("from Booking where show_id=:showId", Booking.class);
    query.setParameter("showId", showId);
    List<Booking> bookings = query.getResultList();

    List<Integer> ids = new ArrayList<>();
    bookings.forEach((i) -> ids.add(i.getId()));

    if (ids.isEmpty())
      return new ArrayList<>();

    return session
      .createQuery("from Place where booking_id in (:ids)", Place.class)
      .setParameterList("ids", ids)
      .getResultList();
  }*/

  /*
  @Override
  public <T> List<T> findAllBySpecification(Specification<T> specification) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<T> query = builder.createQuery(specification.getType());
    Root<T> root = query.from(specification.getType());

    Predicate predicate = specification.toPredicate(root, builder);
    query.where(predicate);
    return manager.createQuery(query).getResultList();
  }

  @Override
  public List<MovieShow> getAllRunningMovieShows() {
    Session session = manager.unwrap(Session.class);
    Query<MovieShow> query = session.createQuery("from MovieShow where is_active is true", MovieShow.class);
    return query.getResultList();
  }

  @Override
  public List<MovieShow> getMovieShowsByFilm(String filmName) {
    Session session = manager.unwrap(Session.class);
    int id = getFilmById(filmName);
    Query<MovieShow> movieQuery = session.createQuery("from MovieShow where film_id=:filmId", MovieShow.class);
    movieQuery.setParameter("filmId", id);
    return movieQuery.getResultList();
  }

  @Override
  public MovieShow getMovieShow(String filmName, Date date) {
    Session session = manager.unwrap(Session.class);
    int id = getFilmById(filmName);

    Query<MovieShow> movieQuery = session.createQuery(
      "from MovieShow where film_id=:filmId and start_time=:date", MovieShow.class);

    movieQuery.setParameter("filmId", id);
    movieQuery.setParameter("date", formatter.format(date));
    return getSingleResult(movieQuery, "Movie show for '" + filmName + "' at '" + date + "' was not found.");
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


  @Override
  public void deleteBooking(int id) {
    Session session = manager.unwrap(Session.class);
    Query query = session.createQuery("delete from Booking where booking_id=:bookingId");
    query.setParameter("bookingId", id);
    query.executeUpdate();
  }

  @Override
  public List<Booking> getBookingByPhone(String phone) {
    Session session = manager.unwrap(Session.class);
    Query<Booking> query = session.createQuery("from Booking where phone_number=:phone", Booking.class);
    query.setParameter("phone", phone);
    return query.getResultList();
  }

   */

  /*
  private int getFilmById(String filmName) {
    Session session = manager.unwrap(Session.class);
    Query<Film> query = session.createQuery("from Film where film_name=:film", Film.class);
    query.setParameter("film", filmName);
    return getSingleResult(query,"No movie shows for " + filmName + "' found.").getId();
  }

   */
}
