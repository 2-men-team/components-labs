package com.twomen.backend.persistence;

import com.twomen.backend.entity.Film;
import com.twomen.backend.util.TimedCache;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.time.Period;
import java.util.List;

@Repository
public class NonFilteredProvider {
  private static final String SUPPLIER_URL = "http://localhost:9091/api";

  private final TimedCache<Integer, List<Film>> cache = new TimedCache<>(Period.ofDays(1));

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

  private <T> T makeRequest(String url, Class<T> clazz) {
    RestTemplate template = new RestTemplate();
    return template.getForObject(url, clazz);
  }

  public Film getFilmById(int id) {
    return makeRequest(SUPPLIER_URL + "/details/" + id, Film.class);
  }

  public List<Film> getFilmsForPage(int page) {
    if (cache.containsKey(page)) return cache.get(page);
    List<Film> result = makeRequest(SUPPLIER_URL + "/film-list/" + page, List.class);
    cache.put(page, result);
    return result;
  }
}
