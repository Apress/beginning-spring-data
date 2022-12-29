package com.apress.catalog.repository;

import com.apress.catalog.model.Currency;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CurrencyRepository extends CrudRepository<Currency, Long> {
	// General queries
	List<Currency> findByCode(String code);
	List<Currency> findByCodeAndDescription(String code, String description);

	// Order queries
	List<Currency> findByDescriptionOrderByCodeAsc(String description);
	List<Currency> findByDescriptionOrderByCodeDesc(String description);
}
