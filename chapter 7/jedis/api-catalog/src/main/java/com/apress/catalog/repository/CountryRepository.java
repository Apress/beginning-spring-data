package com.apress.catalog.repository;

import com.apress.catalog.model.Country;
import org.springframework.data.repository.CrudRepository;


public interface CountryRepository extends CrudRepository<Country, Long> { }
