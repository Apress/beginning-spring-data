package com.apress.catalog.repository;

import com.apress.catalog.model.Country;
import com.apress.catalog.model.Currency;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {
	List<Country> findByCode(String code);

	// Manual query
	@Query("SELECT c FROM country c where c.code = :code")
	Currency retrieveByCode(@Param("code") String code);
}
