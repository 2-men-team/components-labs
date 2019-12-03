package com.twomen.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SearchQuery {
  @JsonProperty("api_key")
  private String apiKey;

  @JsonProperty("keys")
  private List<String> keys;

  public SearchQuery() {
  }

  public SearchQuery(List<String> keys) {
    this.keys = keys;
  }

  public List<String> getKeys() {
    return keys;
  }

  public void setKeys(List<String> keys) {
    this.keys = keys;
  }

  public String getApiKey() {
    return apiKey;
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }
}
