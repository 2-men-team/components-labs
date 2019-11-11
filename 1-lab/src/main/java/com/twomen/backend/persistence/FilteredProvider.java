package com.twomen.backend.persistence;

import com.twomen.backend.entity.Film;
import com.twomen.backend.entity.SearchQuery;
import com.twomen.backend.specification.MatchesKeyWords;
import com.twomen.backend.specification.Specification;
import com.twomen.backend.util.TimedCache;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Repository
public class FilteredProvider {
  private static final String SUPPLIER_URL = "http://localhost:9090/api";

  private final TimedCache<String, Set<Film>> cache = new TimedCache<>(Period.ofDays(1));

  public List<Film> getFilmsByKeyWords(List<String> keyWords) {
    return makeRequest("/search", keyWords);
  }

  private List<Film> makeRequest(String path, List<String> keyWords) {
    RestTemplate template = new RestTemplate();
    return template.postForObject(SUPPLIER_URL + path, new SearchQuery(keyWords), List.class);
  }

  public List<Film> getFilmsByKeyWordsCached(List<String> keyWords) {
    long time = System.currentTimeMillis();
    Set<Film> result = new HashSet<>();
    List<String> request = new ArrayList<>();

    for (String key : keyWords) {
      Set<Film> data = cache.get(key);

      if (data == null) {
        request.add(key);
      } else {
        result.addAll(data);
      }
    }

    if (!request.isEmpty()) {
      List<Film> response = makeRequest("/search-perf", keyWords);
      addToCache(request, response);
      result.addAll(response);
    }

    System.out.println("Response time (s): " + (System.currentTimeMillis() - time) / 1000);
    return new ArrayList<>(result);
  }

  // not very efficient
  private void addToCache(List<String> request, List<Film> response) {
    for (String key : request) {
      Specification<Film> spec = new MatchesKeyWords(Collections.singletonList(key));
      Set<Film> set = new HashSet<>();

      for (Film film : response) {
        if (spec.isSatisfiedBy(film)) {
          set.add(film);
        }
      }

      if (!cache.containsKey(key)) {
        cache.put(key, set);
      } else {
        cache.get(key).addAll(set);
      }
    }
  }
}
