package com.apress.catalog.repository;

import com.apress.catalog.model.Country;

import java.util.Optional;

public interface CustomCountryRepository {

    Country save(Country entity);

    Optional<Country> findById(Long id);

    void deleteById(Long id);
}
