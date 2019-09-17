package com.twomen.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "booked_places")
public class Place {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "booking_id")
  private int id;

  @Column(name = "place_number")
  private int placeNumber;

  public Place() {
  }

  public Place(int placeNumber) {
    this.placeNumber = placeNumber;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getPlaceNumber() {
    return placeNumber;
  }

  public void setPlaceNumber(int placeNumber) {
    this.placeNumber = placeNumber;
  }
}
