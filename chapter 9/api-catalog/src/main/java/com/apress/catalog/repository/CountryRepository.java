package com.apress.catalog.repository;

import com.apress.catalog.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long>, QueryByExampleExecutor<Country> {
	List<Country> findByCode(String code);
}


