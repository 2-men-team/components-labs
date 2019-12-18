package com.twomen.backend.persistence;

import com.twomen.backend.entity.Film;
import com.twomen.backend.rest.ServiceUnavailableException;
import com.twomen.backend.util.TimedCache;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class NonFilteredProvider {
  private static final String SUPPLIER_URL = "http://localhost:9091/api";

  private final TimedCache<Integer, List<Film>> cache = new TimedCache<>(Period.ofDays(1));

  public List<Film> getAllFilms() {
    String url = SUPPLIER_URL + "/film-list";
    RetryTemplate retry = new RetryTemplate();
    TimeoutRetryPolicy policy = new TimeoutRetryPolicy();
    policy.setTimeout(3000);
    retry.setRetryPolicy(policy);

    RestTemplate template = new RestTemplate();
    ResponseEntity<List<Film>> response = retry.execute(
        context -> template.exchange(
            url,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Film>>() {}
        ),
        context -> {
          throw new ServiceUnavailableException("NonFiltered provider is not available");
        });

    return response.getBody();
  }

  private <T> T makeRequest(String url, Class<T> clazz) {
    RetryTemplate retry = new RetryTemplate();
    TimeoutRetryPolicy policy = new TimeoutRetryPolicy();
    policy.setTimeout(3000);
    retry.setRetryPolicy(policy);

    RestTemplate template = new RestTemplate();
    return retry.execute(
        context -> template.getForObject(url, clazz),
        context -> {
          throw new ServiceUnavailableException("NonFiltered provider is not available");
        });
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
