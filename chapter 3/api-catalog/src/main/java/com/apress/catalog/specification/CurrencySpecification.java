package com.apress.catalog.specification;

import com.apress.catalog.model.Currency;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CurrencySpecification implements Specification<Currency> {
	
	private static final long serialVersionUID = 2753473399996931822L;
	
	Currency entity;

    public CurrencySpecification(Currency entity) {
        this.entity = entity;
    }

	@Override
	public Predicate toPredicate(Root<Currency> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		//create a new predicate list
		List<Predicate> predicates = new ArrayList<>();

		CriteriaQuery<Currency> cq = criteriaBuilder.createQuery(Currency.class);

		// You need to define the main entity
		Root<Currency> currency = cq.from(Currency.class);

		// Define all the conditions of the query
		Predicate codePredicate = criteriaBuilder.equal(currency.get("code"), entity.getCode());

		predicates.add(codePredicate);

		return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	}
}
