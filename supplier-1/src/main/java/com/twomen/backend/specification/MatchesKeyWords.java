package com.twomen.backend.specification;

import com.twomen.backend.entity.Film;
import com.twomen.backend.entity.MovieShow;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class MatchesKeyWords extends AbstractSpecification<Film> {
  private List<String> keyWords;

  public MatchesKeyWords(List<String> keyWords) {
    this.keyWords = keyWords;
  }

  @Override
  public boolean isSatisfiedBy(Film film) {
    for (String key : keyWords) {
      if (film.getFilmDesc().contains(key) || film.getFilmName().contains(key)) {
        return true;
      }
    }

    return false;
  }

  @Override
  public Predicate toPredicate(Root<Film> root, CriteriaBuilder cb) {
    Predicate predicate = cb.or(cb.like(root.get("filmName"), "%" + keyWords.get(0) + "%"),
      cb.like(root.get("filmDesc"), "%" + keyWords.get(0) + "%"));

    for (int i = 1; i < keyWords.size(); i++) {
      String regexp = "%" + keyWords.get(i) + "%";
      predicate = cb.or(predicate, cb.like(root.get("filmName"), regexp), cb.like(root.get("filmDesc"), regexp));
    }

    return predicate;
  }
}
