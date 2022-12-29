package com.apress.catalog.repository;

import com.apress.catalog.model.Country;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface CountryRepository extends R2dbcRepository<Country, Long> {
	Flux<Country> findByCode(String code);
}
