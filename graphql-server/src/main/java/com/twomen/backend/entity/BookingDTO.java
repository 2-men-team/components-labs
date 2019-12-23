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

  public BookingDTO() {
  }

  public BookingDTO(String film, String firstName, String lastName, String email, String phoneNumber, List<Integer> places) {
    this.film = film;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.places = places;
  }

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

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private String film;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private List<Integer> places;

    public Builder setFilm(String film) {
      this.film = film;
      return this;
    }

    public Builder setFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public Builder setLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public Builder setEmail(String email) {
      this.email = email;
      return this;
    }

    public Builder setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    public Builder setPlaces(List<Integer> places) {
      this.places = places;
      return this;
    }

    public BookingDTO build() {
      return new BookingDTO(film, firstName, lastName, email, phoneNumber, places);
    }
  }
}
