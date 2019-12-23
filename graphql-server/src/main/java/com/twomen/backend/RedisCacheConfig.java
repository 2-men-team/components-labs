package com.twomen.backend;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;

@Configuration
public class RedisCacheConfig extends CachingConfigurerSupport {
  private static final String HOST = Config.HOST_IP;
  private static final int PORT = 6379;
  private static final Duration TTL = Duration.ofDays(1);

  @Bean
  public RedisConnectionFactory redisConnectionFactory() {
    return new JedisConnectionFactory(new RedisStandaloneConfiguration(HOST, PORT));
  }

  @Bean
  public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
    RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(cf);
    return redisTemplate;
  }

  @Bean
  public CacheManager cacheManager(RedisConnectionFactory cf) {
    RedisCacheWriter writer = RedisCacheWriter.nonLockingRedisCacheWriter(cf);
    RedisCacheConfiguration configuration = RedisCacheConfiguration
        .defaultCacheConfig()
        .entryTtl(TTL);
    return new RedisCacheManager(writer, configuration);
  }
}
