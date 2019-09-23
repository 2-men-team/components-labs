package com.twomen.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SearchQuery {
  @JsonProperty("keys")
  private List<String> keys;

  public SearchQuery() {
  }

  public List<String> getKeys() {
    return keys;
  }

  public void setKeys(List<String> keys) {
    this.keys = keys;
  }
}
