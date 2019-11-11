package com.twomen.backend.util;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TimedCache<K, V> {
  private final Map<K, Data<V>> map = new HashMap<>();
  private final Period interval;

  private static class Data<V> {
    private V value;
    private LocalDateTime time;

    private Data(V value, LocalDateTime time) {
      this.value = value;
      this.time = time;
    }

    private Data(V value) {
      this(value, LocalDateTime.now());
    }
  }

  public TimedCache(Period interval) {
    this.interval = Objects.requireNonNull(interval);
  }

  public V get(K key) {
    Data<V> data = map.get(key);
    if (data == null) return null;

    if (data.time.isBefore(LocalDateTime.now().minus(interval))) {
      map.remove(key);
      return null;
    }

    return data.value;
  }

  public V put(K key, V value) {
    Data<V> data = map.put(key, new Data<>(value));
    return data == null ? null : data.value;
  }

  public boolean containsKey(K key) {
    return get(key) != null;
  }
}
