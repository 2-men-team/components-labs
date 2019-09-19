package com.twomen.backend.service;

import com.twomen.backend.entity.Booking;
import com.twomen.backend.entity.Film;
import com.twomen.backend.entity.MovieShow;
import com.twomen.backend.persistence.BookingDAO;
import com.twomen.backend.specification.MatchesKeyWords;
import com.twomen.backend.specification.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class BookingServiceFacadeImpl implements BookingServiceFacade {
  private final BookingDAO dao;

  @Autowired
  public BookingServiceFacadeImpl(BookingDAO dao) {
    this.dao = dao;
  }

  @Override
  @Transactional
  public List<Film> getAllRunningFilms() {
    return dao.getAllRunningFilms();
  }

  @Override
  @Transactional
  public List<MovieShow> getAllRunningMovieShows() {
    return dao.getAllRunningMovieShows();
  }

  @Override
  @Transactional
  public List<MovieShow> getMovieShowsByFilm(String film) {
    return dao.getMovieShowsByFilm(film);
  }

  @Override
  @Transactional
  public MovieShow getMovieShow(String name, Date date) {
    return dao.getMovieShow(name, date);
  }

  @Override
  @Transactional
  public void makeBooking(Booking info) {
    info.setId(0);
    dao.makeBooking(info);
  }

  @Override
  @Transactional
  public List<Booking> getBookingByPhone(String phone) {
    return dao.getBookingByPhone(phone);
  }

  @Override
  @Transactional
  public void deleteBooking(int id) {
    dao.deleteBooking(id);
  }

  @Override
  public List<Film> findAllByKeyWords(List<String> keyWords) {
    Specification<Film> specification = new MatchesKeyWords(keyWords);
    return dao.findAllBySpecification(specification);
  }
}
