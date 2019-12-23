package com.twomen.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.twomen.backend.booking.ShowResponse;
import com.twomen.backend.persistence.BookingProvider;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "movie_shows")
public class MovieShow {
  @Id
  @JsonIgnore
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "show_id")
  private int id;

  @JsonIgnore
  @Column(name = "film_id")
  private int filmId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "film_id", insertable = false, updatable = false)
  private Film film;

  @Column(name = "start_time")
  @Temporal(TemporalType.TIMESTAMP)
  private Date startTime;

  @Column(name = "end_time")
  @Temporal(TemporalType.TIMESTAMP)
  private Date endTime;

  @Column(name = "price")
  private int price;

  @Column(name = "is_active")
  private boolean isActive;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "show_id")
  private List<Place> places;

  public MovieShow() {
  }

  public MovieShow(int filmId, Date startTime, Date endTime, int price, boolean isActive) {
    this.filmId = filmId;
    this.startTime = startTime;
    this.endTime = endTime;
    this.price = price;
    this.isActive = isActive;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getFilmId() {
    return filmId;
  }

  public void setFilmId(int filmId) {
    this.filmId = filmId;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  public List<Place> getPlaces() {
    return places;
  }

  public void setPlaces(List<Place> places) {
    this.places = places;
  }

  public Film getFilm() {
    return film;
  }

  public void setFilm(Film film) {
    this.film = film;
  }

  public static MovieShow of(ShowResponse response) {
    MovieShow show = new MovieShow();
    show.setFilmId(response.getFilmId());
    show.setStartTime(new Date(response.getStartTime()));
    show.setEndTime(new Date(response.getEndTime()));
    show.setPrice(response.getPrice());
    show.setPlaces(BookingProvider.toPlaces(response.getPlacesList()));
    show.setId(response.getShowId());
    return show;
  }
}
