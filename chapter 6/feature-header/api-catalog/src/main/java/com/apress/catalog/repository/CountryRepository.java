package com.apress.catalog.repository;

import com.apress.catalog.model.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends CrudRepository<Country, Long> {
	List<Country> findByCode(String code);

	// New query that replaces the old one
	@Query("SELECT c FROM Country c WHERE c.id = ?1")
	Optional<Country> findByIdUsingQuery(Long id);
}
