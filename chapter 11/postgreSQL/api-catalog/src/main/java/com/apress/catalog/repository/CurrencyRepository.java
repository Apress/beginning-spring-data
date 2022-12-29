package com.apress.catalog.repository;

import com.apress.catalog.model.Currency;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface CurrencyRepository extends R2dbcRepository<Currency, Long> {
	// General queries
	Flux<Currency> findByCode(String code);
	Flux<Currency> findByCodeAndDescription(String code, String description);

	// Order queries
	Flux<Currency> findByDescriptionOrderByCodeAsc(String description);
	Flux<Currency> findByDescriptionOrderByCodeDesc(String description);
}
