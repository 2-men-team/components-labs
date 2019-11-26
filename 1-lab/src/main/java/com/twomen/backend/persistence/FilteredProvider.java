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

  public List<Film> getFilmsByKeyWords(List<String> keyWords) {
    return makeRequest("/search", keyWords);
  }

  private List<Film> makeRequest(String path, List<String> keyWords) {
    RestTemplate template = new RestTemplate();
    return template.postForObject(SUPPLIER_URL + path, new SearchQuery(keyWords), List.class);
  }
}
