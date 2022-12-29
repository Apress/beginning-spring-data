package com.apress.catalog.repository;

import com.apress.catalog.model.State;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StateRepository extends CrudRepository<State, Long> {
	List<State> findByCode(String code);

	List<State> findAllByCountryId(Long id);
}
