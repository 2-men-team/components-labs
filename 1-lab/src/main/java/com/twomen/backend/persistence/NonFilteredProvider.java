package com.twomen.backend.persistence;

import com.twomen.backend.entity.Film;
import com.twomen.backend.entity.PerfData;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class NonFilteredProvider {
  private static final String SUPPLIER_URL = "http://localhost:9091/api";

  public List<Film> getAllFilms() {
    String url = SUPPLIER_URL + "/film-list";
    RestTemplate template = new RestTemplate();
    ResponseEntity<List<Film>> response = template.exchange(
      url,
      HttpMethod.GET,
      null,
      new ParameterizedTypeReference<List<Film>>(){}
    );
    return response.getBody();
  }

  public Film getFilmById(int id) {
    String url = SUPPLIER_URL + "/details/" + id;
    RestTemplate template = new RestTemplate();
    return template.getForObject(url, Film.class);
  }

  public List<PerfData> getPerfData() {
    RestTemplate template = new RestTemplate();
    return template.getForObject(SUPPLIER_URL + "/perf", List.class);
  }
}
