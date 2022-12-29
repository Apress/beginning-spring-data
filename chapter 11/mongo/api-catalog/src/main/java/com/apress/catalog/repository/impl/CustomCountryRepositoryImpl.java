package com.apress.catalog.repository.impl;

import com.apress.catalog.model.Country;
import com.apress.catalog.repository.CustomCountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CustomCountryRepositoryImpl implements CustomCountryRepository {

    private final ReactiveMongoTemplate mongoTemplate;

    @Autowired
    public CustomCountryRepositoryImpl(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Mono<Country> save(Country entity) {
        return mongoTemplate.save(entity);
    }

    @Override
    public Mono<Country> findById(Long id) {
        return mongoTemplate.findById(id, Country.class);
    }

    @Override
    public void deleteById(Long id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Country.class);
    }

    public Flux<Country> findAll(Example<Country> of) {
        return null;
    }
}
