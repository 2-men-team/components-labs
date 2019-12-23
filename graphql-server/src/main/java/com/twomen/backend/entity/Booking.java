package com.twomen.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.twomen.backend.booking.BookingResponse;
import com.twomen.backend.persistence.BookingProvider;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {
  @Id
  @JsonIgnore
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "booking_id")
  private int id;

  @JsonIgnore
  @Column(name = "show_id")
  private int showId;

  @Transient
  private String filmName;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @Column(name = "phone_number")
  private String phoneNumber;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "booking_id")
  private List<Place> places;

  public Booking() {
  }

  public Booking(int showId, String filmName, String firstName, String lastName, String email, String phoneNumber, List<Place> places) {
    this.showId = showId;
    this.filmName = filmName;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.places = places;
  }

  public static class Builder {
    private int id;
    private int showId;
    private String filmName;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private List<Place> places;

    public Builder setShowId(int showId) {
      this.showId = showId;
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

    public Builder setFilmName(String filmName) {
      this.filmName = filmName;
      return this;
    }

    public Builder setPlaces(List<Place> places) {
      this.places = places;
      return this;
    }

    public Booking build() {
      return new Booking(showId, filmName, firstName, lastName, email, phoneNumber, places);
    }
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

  public int getShowId() {
    return showId;
  }

  public void setShowId(int showId) {
    this.showId = showId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public List<Place> getPlaces() {
    return places;
  }

  public void setPlaces(List<Place> places) {
    this.places = places;
  }

  public static Booking of(BookingResponse response) {
    return new Booking.Builder()
      .setFilmName(response.getFilmName())
      .setPhoneNumber(response.getPhoneNumber())
      .setEmail(response.getEmail())
      .setLastName(response.getLastName())
      .setFirstName(response.getFirstName())
      .setPlaces(BookingProvider.toPlaces(response.getPlacesList()))
      .build();
  }
}

