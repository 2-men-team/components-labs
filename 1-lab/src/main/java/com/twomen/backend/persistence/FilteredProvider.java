package com.twomen.backend.persistence;

import com.twomen.backend.entity.Film;
import com.twomen.backend.entity.PerfData;
import com.twomen.backend.entity.SearchQuery;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;

@Repository
public class FilteredProvider {
  private static final String SUPPLIER_URL = "http://localhost:9090/api";
  private static final HttpHeaders headers = new HttpHeaders();

  private final Map<Integer, CacheData> cache = new HashMap<>();

  private static final class CacheData {
    PerfData data;
    LocalDate date;

    CacheData(PerfData data, LocalDate date) {
      this.data = data;
      this.date = date;
    }
  }

  public FilteredProvider() {
  }

  public List<Film> getFilmsByKeyWords(List<String> keyWords) {
    RestTemplate template = new RestTemplate();
    return template.postForObject(SUPPLIER_URL + "/search", new SearchQuery(keyWords), List.class);
  }

  public List<PerfData> getPerfData(List<Integer> idxs) {
    long time = System.currentTimeMillis();
    List<PerfData> result = new ArrayList<>();
    List<Integer> request = new ArrayList<>();

    for (int id : idxs) {
      if (!cache.containsKey(id) ||
          cache.get(id).date.isBefore(LocalDate.now().minusDays(1))) {
        request.add(id);
      } else {
        result.add(cache.get(id).data);
      }
    }

    RestTemplate template = new RestTemplate();
    List<PerfData> response = Collections.emptyList();

    if (!request.isEmpty()) {
      response = template.postForObject(SUPPLIER_URL + "/perf", request, List.class);
    }

    for (PerfData elem : response) {
      cache.put(elem.getId(), new CacheData(elem, LocalDate.now()));
    }

    result.addAll(response);

    System.out.println("Response time (s): " + (System.currentTimeMillis() - time) * 1000);
    return result;
  }
}
