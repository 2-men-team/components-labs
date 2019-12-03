package com.twomen.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BookingDTO {
  @JsonProperty("api_key")
  private String apiKey;

  @JsonProperty("film")
  private String film;

  @JsonProperty("first_name")
  private String firstName;

  @JsonProperty("last_name")
  private String lastName;

  @JsonProperty("email")
  private String email;

  @JsonProperty("phone_number")
  private String phoneNumber;

  @JsonProperty("places")
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
