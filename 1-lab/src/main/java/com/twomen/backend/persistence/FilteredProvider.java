package com.twomen.backend.persistence;

import com.twomen.backend.entity.Film;
import com.twomen.backend.entity.SearchQuery;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class FilteredProvider {
  private static final String SUPPLIER_URL = "http://localhost:9090/api/search";
  private static final HttpHeaders headers = new HttpHeaders();

  public FilteredProvider() {
  }

  public List<Film> getFilmsByKeyWords(List<String> keyWords) {
    RestTemplate template = new RestTemplate();
    return template.postForObject(SUPPLIER_URL, new SearchQuery(keyWords), List.class);
  }
}
