package com.twomen.backend.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractSpecification<T> implements Specification<T> {
  @Override
  public boolean isSatisfiedBy(T t) {
    throw new IllegalArgumentException();
  }

  @Override
  public Predicate toPredicate(Root<T> root, CriteriaBuilder cb) {
    throw new IllegalArgumentException();
  }

  @Override
  public Class<T> getType() {
    ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
    return (Class<T>) type.getActualTypeArguments()[0];
  }
}
