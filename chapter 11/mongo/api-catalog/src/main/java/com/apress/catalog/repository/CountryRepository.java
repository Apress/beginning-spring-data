package com.apress.catalog.repository;

import com.apress.catalog.model.Country;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CountryRepository extends ReactiveMongoRepository<Country, Long> {
	Flux<Country> findByCode(String code);

	//This is a custom query that find just for one field
	@Query(value = "{'code': ?0}")
	Flux<Country> findCustom(String code);

	//This is a custom query combine the condition on the name of the method with the query
	@Query(value = "{'code': ?0}")
	Flux<Country> findEnabled(String code);
}
