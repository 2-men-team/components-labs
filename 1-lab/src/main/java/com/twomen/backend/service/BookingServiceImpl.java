package com.twomen.backend.service;

import com.twomen.backend.entity.Booking;
import com.twomen.backend.entity.Film;
import com.twomen.backend.entity.MovieShow;
import com.twomen.backend.persistence.BookingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
  private final BookingDAO dao;

  @Autowired
  public BookingServiceImpl(BookingDAO dao) {
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
  public MovieShow getMovieShowById(int id) {
    return dao.getMovieShowById(id);
  }

  @Override
  @Transactional
  public void makeBooking(Booking info) {
    info.setId(0);
    dao.makeBooking(info);
  }

  @Override
  @Transactional
  public void deleteBooking(int id) {
    dao.deleteBooking(id);
  }
}
