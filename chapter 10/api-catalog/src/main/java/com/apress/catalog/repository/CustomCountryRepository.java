package com.apress.catalog.repository;

import com.apress.catalog.model.Country;

import java.util.Optional;
import java.util.UUID;

public interface CustomCountryRepository {
    Country save(Country entity);

    Optional<Country> findById(UUID id);

    void deleteById(UUID id);
}