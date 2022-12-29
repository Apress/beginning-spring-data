package com.apress.catalog.repository;

import com.apress.catalog.model.State;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface StateRepository extends ReactiveMongoRepository<State, Long> {
	Flux<State> findByCode(String code);

	Flux<State> findAllByCountryId(Long id);
}
