package com.twomen.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "films")
public class Film {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "film_id")
  private int id;

  @Column(name = "film_name")
  private String filmName;

  @Column(name = "film_desc")
  private String filmDesc;

  public Film(String filmName, String filmDesc) {
    this.filmName = filmName;
    this.filmDesc = filmDesc;
  }

  public Film() {
  }

  public String getFilmDesc() {
    return filmDesc;
  }

  public void setFilmDesc(String filmDesc) {
    this.filmDesc = filmDesc;
  }

  public String getFilmName() {
    return filmName;
  }

  public void setFilmName(String filmName) {
    this.filmName = filmName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
