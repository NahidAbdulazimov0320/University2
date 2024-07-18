package com.example.university.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@EnableCaching // Enable caching support in Spring
public class CachingConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        Caffeine<Object, Object> caffeineBuilder = Caffeine.newBuilder()
                .maximumSize(100)
                .expireAfterAccess(Duration.ofMinutes(1));
        cacheManager.setCaffeine(caffeineBuilder);
        return cacheManager;
    }
}
