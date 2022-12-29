package com.apress.catalog.repository;

import com.apress.catalog.model.State;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface StateRepository extends R2dbcRepository<State, Long> {
	Flux<State> findByCode(String code);

	Flux<State> findAllByCountryId(Long id);
}
