package com.twomen.backend.persistence;

import com.twomen.backend.entity.Film;
import com.twomen.backend.entity.SearchQuery;
import com.twomen.backend.rest.ServiceUnavailableException;
import com.twomen.backend.specification.MatchesKeyWords;
import com.twomen.backend.specification.Specification;
import com.twomen.backend.util.TimedCache;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Repository
public class FilteredProvider {
  private static final String SUPPLIER_URL = "http://localhost:9090/api";

  public List<Film> getFilmsByKeyWords(List<String> keyWords) {
    return makeRequest("/search", keyWords);
  }

  private List<Film> makeRequest(String path, List<String> keyWords) {
    RetryTemplate retry = new RetryTemplate();
    TimeoutRetryPolicy policy = new TimeoutRetryPolicy();
    policy.setTimeout(3000);
    retry.setRetryPolicy(policy);

    RestTemplate template = new RestTemplate();
    ResponseEntity<List<Film>> response = retry.execute(
        context -> template.exchange(
            SUPPLIER_URL + path,
            HttpMethod.POST,
            new HttpEntity<>(new SearchQuery(keyWords)),
            new ParameterizedTypeReference<List<Film>>() {}
        ),
        context -> {
          throw new ServiceUnavailableException("Filtered provider is not available");
        });

    return response.getBody();
  }
}
