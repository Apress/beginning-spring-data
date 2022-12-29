package com.apress.catalog.repository;

import com.apress.catalog.model.Country;
import reactor.core.publisher.Mono;

public interface CustomCountryRepository {

    Mono<Country> save(Country entity);

    Mono<Country> findById(Long id);

    void deleteById(Long id);
}
