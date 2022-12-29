package com.apress.catalog.repository;

import com.apress.catalog.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface CountryRepository extends CrudRepository<Country, Long>, QueryByExampleExecutor<Country> {
}
