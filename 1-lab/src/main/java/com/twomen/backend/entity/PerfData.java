package com.twomen.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "perf")
public class PerfData {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "num")
  private int num;

  public PerfData(int num) {
    this.num = num;
  }

  public PerfData() {
  }

  public int getNum() {
    return num;
  }

  public int getId() {
    return id;
  }
}
