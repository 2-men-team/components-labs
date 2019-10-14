package com.twomen.backend.entity;

import java.util.List;

public class BookingDTO {
  private String film;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private List<Integer> places;

  public List<Integer> getPlaces() {
    return places;
  }

  public void setPlaces(List<Integer> places) {
    this.places = places;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getFilm() {
    return film;
  }

  public void setFilm(String film) {
    this.film = film;
  }
}
