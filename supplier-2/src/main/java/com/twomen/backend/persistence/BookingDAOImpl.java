package com.twomen.backend.persistence;

import com.twomen.backend.entity.Film;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
// CREATIONAL PATTERN
public class BookingDAOImpl implements BookingDAO {
  private static final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  private EntityManager manager;

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
  public Film getFilmById(int id) {
    Session session = manager.unwrap(Session.class);
    Query<Film> query = session.createQuery("from Film where film_id=:id", Film.class);
    query.setParameter("id", id);
    return query.getSingleResult();
  }

  @Override
  public List<Film> getFilmsBetweenIds(int from, int to) {
    Session session = manager.unwrap(Session.class);
    Query<Film> query = session.createQuery("from Film where film_id between :a and :b", Film.class);
    query.setParameter("a", from);
    query.setParameter("b", to);
    return query.getResultList();
  }

  /*
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

  public <T> List<T> findAllBySpecification(Specification<T> specification) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<T> query = builder.createQuery(specification.getType());
    Root<T> root = query.from(specification.getType());

    Predicate predicate = specification.toPredicate(root, builder);
    query.where(predicate);
    return manager.createQuery(query).getResultList();
  }

  private int getFilmById(String filmName) {
    Session session = manager.unwrap(Session.class);
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
   */
}
