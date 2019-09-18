package com.twomen.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "booked_places", schema = "CRUD_TEST")
public class Place implements Serializable {
  private static final long serialVersionUID = -7627696889364515583L;

  @Id
  @Column(name = "booking_id")
  private int id;

  @Id
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

  @Override
  public int hashCode() {
    return Objects.hash(placeNumber);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null) return false;
    if (this.getClass() != obj.getClass()) return false;
    Place that = (Place) obj;
    return this.placeNumber == that.placeNumber;
  }

  public static List<Place> convert(List<Integer> places) {
    List<Place> list = new ArrayList<>();
    places.forEach((i) -> list.add(new Place(i)));
    return list;
  }
}
