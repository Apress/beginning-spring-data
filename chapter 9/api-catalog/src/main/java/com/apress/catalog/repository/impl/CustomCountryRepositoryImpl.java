package com.apress.catalog.repository.impl;

import com.apress.catalog.model.Country;
import com.apress.catalog.repository.CustomCountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomCountryRepositoryImpl implements CustomCountryRepository {
    private final Neo4jTemplate neo4jTemplate;

    @Autowired
    public CustomCountryRepositoryImpl(Neo4jTemplate neo4jTemplate) {
        this.neo4jTemplate = neo4jTemplate;
    }

    @Override
    public Country save(Country entity) {
        return neo4jTemplate.save(entity);
    }

    @Override
    public Optional<Country> findById(Long id) {
        return neo4jTemplate.findById(id, Country.class);
    }

    @Override
    public void deleteById(Long id) {
        neo4jTemplate.deleteById(id, Country.class);
    }
}
