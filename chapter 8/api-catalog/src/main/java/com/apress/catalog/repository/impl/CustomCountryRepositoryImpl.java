package com.apress.catalog.repository.impl;

import com.apress.catalog.model.Country;
import com.apress.catalog.repository.CustomCountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomCountryRepositoryImpl implements CustomCountryRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public CustomCountryRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Country save(Country entity) {
        return mongoTemplate.save(entity);
    }

    @Override
    public Optional<Country> findById(Long id) {
        Country country = mongoTemplate.findById(id, Country.class);
        return Optional.of(country);
    }

    @Override
    public void deleteById(Long id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Country.class);
    }

    public Iterable<Country> findAll(Example<Country> of) {
        return null;
    }
}
