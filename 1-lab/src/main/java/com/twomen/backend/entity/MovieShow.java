package com.twomen.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movie_shows")
public class MovieShow {
  @Id
  @JsonIgnore
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "show_id")
  private int id;

  @Column(name = "film_id")
  private int filmId;

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

  /*
  public List<Place> getPlaces() {
    return places;
  }

  public void setPlaces(List<Place> places) {
    this.places = places;
  }

   */
}
