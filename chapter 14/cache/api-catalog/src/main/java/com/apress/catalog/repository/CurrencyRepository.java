package com.apress.catalog.repository;

import com.apress.catalog.model.Currency;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Long> {
	// General queries
	List<Currency> findByCode(String code);
	List<Currency> findByCodeAndDescription(String code, String description);

	// Order queries
	List<Currency> findByDescriptionOrderByCodeAsc(String description);
	List<Currency> findByDescriptionOrderByCodeDesc(String description);
	
	// Manual query
	@Query("SELECT c FROM Currency c where c.code = :code")
	Currency retrieveByCode(@Param("code") String code);
}
