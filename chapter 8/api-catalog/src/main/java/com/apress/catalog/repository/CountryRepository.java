package com.apress.catalog.repository;

import com.apress.catalog.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface CountryRepository extends MongoRepository<Country, Long> {
	List<Country> findByCode(String code);

	//This is a custom query that find just for one field
	@Query(value = "{'code': ?0}")
	List<Country> findCustom(String code);

	//This is a custom query combine the condition on the name of the method with the query
	@Query(value = "{'code': ?0}")
	List<Country> findEnabled(String code);
}
