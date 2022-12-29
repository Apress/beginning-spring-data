package com.apress.catalog.service;

import com.apress.catalog.dto.CurrencyDTO;
import com.apress.catalog.mapper.ApiMapper;
import com.apress.catalog.model.Currency;
import com.apress.catalog.repository.CurrencyRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class CurrencyService {

	CurrencyRepository repository;
	Validator validator;
	
	@Autowired
	public CurrencyService(CurrencyRepository repository, Validator validator) {
		this.repository = repository;
		this.validator = validator;
	}
	
	public CurrencyDTO getById(Long id) {
		CurrencyDTO response = null;
		Optional<Currency> currency = repository.findById(id);
		
		if(currency.isPresent()) {
			response = ApiMapper.INSTANCE.entityToDTO(currency.get());
		}
		
		return response;
	}

	public CurrencyDTO save(CurrencyDTO currency) {
		return saveInformation(currency);
	}

	@Transactional
	public CurrencyDTO update(CurrencyDTO currency) {
		return saveInformation(currency);
	}

	public void delete(Long id) {
		Optional<Currency> currency = repository.findById(id);

		if(currency.isPresent()) {
			currency.get().setEnabled(Boolean.FALSE);
			repository.save(currency.get());
		}
	}

	private CurrencyDTO saveInformation(CurrencyDTO currency) {
		Currency entity = ApiMapper.INSTANCE.DTOToEntity(currency);

		Set<ConstraintViolation<Currency>> violations = validator.validate(entity);
		if(!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}

		Currency savedEntity = repository.save(entity);

		return ApiMapper.INSTANCE.entityToDTO(savedEntity);
	}
}
