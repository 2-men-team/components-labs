package com.twomen.backend.persistence;

import com.twomen.backend.entity.Booking;
import com.twomen.backend.entity.Film;
import com.twomen.backend.entity.MovieShow;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import org.hibernate.query.Query;
import java.util.Date;
import java.util.List;

@Repository
public class BookingDAOImpl implements BookingDAO {
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
    int id = query.getSingleResult().getId();

    Query<MovieShow> movieQuery = session.createQuery("from MovieShow where film_id=:filmId", MovieShow.class);
    movieQuery.setParameter("filmId", id);

    return movieQuery.getResultList();
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
    movieQuery.setParameter("date", date);
    return movieQuery.getSingleResult();
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
    session.saveOrUpdate(info);
  }

  // FIXME check booked places
  @Override
  public void deleteBooking(int id) {
    Session session = manager.unwrap(Session.class);
    Query query = session.createQuery("delete from Booking where booking_id=:bookingId");
    query.setParameter("bookingId", id);
    query.executeUpdate();
  }
}
