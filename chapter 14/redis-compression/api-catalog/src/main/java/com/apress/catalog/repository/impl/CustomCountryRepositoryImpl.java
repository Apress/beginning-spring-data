package com.apress.catalog.repository.impl;

import com.apress.catalog.model.Country;
import com.apress.catalog.repository.CustomCountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomCountryRepositoryImpl implements CustomCountryRepository {

    //Use the key to create a unique element in the database like country_xxx
    private static final Object COUNTRY_KEY = "country";

    final RedisTemplate redisTemplate;
    private HashOperations hashOperations;

    @Autowired
    public CustomCountryRepositoryImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;

        //Obtain the HashOperations to interact directly with the database
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Country save(Country entity) {
        //Execute a save operation which not return anything so you need to do a find operation to return it
        hashOperations.put(COUNTRY_KEY, entity.getId(), (Object) entity);
        return findById(entity.getId()).get();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return Optional.of((Country) hashOperations.get(COUNTRY_KEY, id));
    }

    @Override
    public void deleteById(Long id) {
        //This operation only need the “prefix” of the key and the value country_xxxx to delete
        hashOperations.delete(COUNTRY_KEY, id);
    }
}
