package com.twomen.backend.persistence;

import com.twomen.backend.entity.Film;
import com.twomen.backend.exceptions.NotFoundException;
import com.twomen.backend.specification.Specification;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

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

  public <T> List<T> findAllBySpecification(Specification<T> specification) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<T> query = builder.createQuery(specification.getType());
    Root<T> root = query.from(specification.getType());

    Predicate predicate = specification.toPredicate(root, builder);
    query.where(predicate);
    return manager.createQuery(query).getResultList();
  }

  @Override
  public Film getFilmById(int id) {
    Session session = manager.unwrap(Session.class);
    Query<Film> query = session.createQuery("from Film where film_id=:id", Film.class);
    query.setParameter("id", id);
    return getSingleResult(query,"No movie shows for " + id + "' found.");
  }

  @Override
  public Film getFilmByName(String name) {
    Session session = manager.unwrap(Session.class);
    Query<Film> query = session.createQuery("from Film where film_name=:name", Film.class);
    query.setParameter("name", name);
    return getSingleResult(query,"No movie shows for " + name + "' found.");
  }

  private static <T> T getSingleResult(Query<T> query, String message) {
    List<T> result = query.getResultList();
    System.err.println(result);
    if (result.isEmpty()) {
      throw new NotFoundException(message);
    } else {
      return result.get(0);
    }
  }
}
