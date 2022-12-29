package com.apress.catalog.repository;

import com.apress.catalog.model.State;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StateRepository extends MongoRepository<State, Long> {
	List<State> findByCode(String code);

	List<State> findAllByCountryId(Long id);
}
