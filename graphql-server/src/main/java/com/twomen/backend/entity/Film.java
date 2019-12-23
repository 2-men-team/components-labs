package com.twomen.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "films")
public class Film {
  @Id
  @JsonIgnore
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

  @Override
  public int hashCode() {
    // films are uniquely identified by their ids
    return Integer.hashCode(id);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) return false;
    if (o == this) return true;
    if (o.getClass() != this.getClass()) return false;
    Film that = (Film) o;
    return this.id == that.id;
  }
}
