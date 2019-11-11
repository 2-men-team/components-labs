package com.twomen.backend.persistence;

import com.twomen.backend.entity.Film;
import com.twomen.backend.entity.SearchQuery;
import com.twomen.backend.specification.MatchesKeyWords;
import com.twomen.backend.specification.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;

@Repository
public class FilteredProvider {
  private static final String SUPPLIER_URL = "http://localhost:9090/api";
  private static final HttpHeaders headers = new HttpHeaders();

  private final Map<String, CacheData> cache = new HashMap<>();

  private static final class CacheData {
    Set<Film> data;
    LocalDate date;

    CacheData(Set<Film> data, LocalDate date) {
      this.data = data;
      this.date = date;
    }
  }

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
      CacheData value = cache.get(key);

      if (value == null) {
        request.add(key);
      } else if (value.date.isBefore(LocalDate.now().minusDays(1))) {
        cache.remove(key);
        request.add(key);
      } else {
        result.addAll(value.data);
      }
    }

    if (!request.isEmpty()) {
      System.out.println(request.size());
      System.out.println(keyWords.size());
      List<Film> response = makeRequest("/search-perf", keyWords);
      // TODO: doesnt actually add anything to the cache: during debug response.size() == 0
      addToCache(request, response);
      result.addAll(response);
    }

    System.out.println(cache);
    System.out.println("Response time (s): " + (System.currentTimeMillis() - time) / 1000);
    return new ArrayList<>(result);
  }

  // not very efficient
  private void addToCache(List<String> request, List<Film> response) {
    for (Film film : response) {
      for (String key : request) {
        Specification<Film> spec = new MatchesKeyWords(Collections.singletonList(key));

        if (spec.isSatisfiedBy(film)) {
          CacheData value = cache.get(key);
          System.out.println(key);

          if (value != null) value.data.add(film);
          else {
            CacheData data = new CacheData(new HashSet<>(Collections.singletonList(film)), LocalDate.now());
            cache.put(key, data);
          }
        }
      }
    }
  }
}
