package com.apress.catalog.cache;

import com.apress.catalog.repository.CountryRepository;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;


@Configuration
@EnableCaching//Enable the mechanism of cache on the application
public class CacheManagerConfiguration {

    public static final String CATALOG_COUNTRY = "CATALOG_COUNTRY";

    private final CacheConfiguration cacheConfiguration;

    private final CountryRepository countryRepository;

    @Autowired
    public CacheManagerConfiguration(final CacheConfiguration cacheConfiguration,
                                     final CountryRepository countryRepository) {
        this.cacheConfiguration = cacheConfiguration;
        this.countryRepository = countryRepository;
    }

    // Define the names and which type of cache use it.
    @Bean
    public CacheManager cacheManager() {
        CacheSettings cacheCitySettings = cacheConfiguration.getCacheSettings(CATALOG_COUNTRY);

        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(Lists
                .newArrayList(buildCaffeineCache(CATALOG_COUNTRY, cacheCitySettings, countryRepository::findById)));

        return simpleCacheManager;
    }

    // Define the cache, the expiration and the number of elements that exist in the cache. Also, define the mechanism to obtain the information
    public static CaffeineCache buildCaffeineCache(String cacheName, CacheSettings settings,
                                                   Function<Long, Object> serviceCall) {

        return new CaffeineCache(cacheName,
                Caffeine.newBuilder().refreshAfterWrite(settings.getRefreshAfterWriteTime(), TimeUnit.MINUTES)
                        .expireAfterWrite(settings.getExpireAfterWriteTime(), TimeUnit.MINUTES)
                        .maximumSize(settings.getMaxSize()).build(key -> serviceCall.apply((Long) key)));
    }
}