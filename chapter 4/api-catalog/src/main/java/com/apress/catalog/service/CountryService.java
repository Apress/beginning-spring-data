package com.apress.catalog.service;

import com.apress.catalog.dto.CountryDTO;
import com.apress.catalog.mapper.ApiMapper;
import com.apress.catalog.model.Country;
import com.apress.catalog.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import java.util.Optional;
import java.util.Set;

@Service
public class CountryService {

	CountryRepository repository;
	Validator validator;

	@Autowired
	public CountryService(CountryRepository repository,  Validator validator) {
		this.repository = repository;
		this.validator = validator;
	}
	
	public CountryDTO getById(Long id) {
		CountryDTO response = null;
		Optional<Country> country = repository.findById(id);
		
		if(country.isPresent()) {
			response = ApiMapper.INSTANCE.entityToDTO(country.get());
		}
		
		return response;
	}

	public CountryDTO save(CountryDTO currency) {
		return saveInformation(currency);
	}

	public CountryDTO update(CountryDTO currency) {
		return saveInformation(currency);
	}

	public void delete(Long id) {
		Optional<Country> country = repository.findById(id);

		if(country.isPresent()) {
			country.get().setEnabled(Boolean.FALSE);
			repository.save(country.get());
		}
	}

	private CountryDTO saveInformation(CountryDTO country) {
		Country entity = ApiMapper.INSTANCE.DTOToEntity(country);
		Country savedEntity = repository.save(entity);

		Set<ConstraintViolation<Country>> violations = validator.validate(entity);
		if(!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}

		return ApiMapper.INSTANCE.entityToDTO(savedEntity);
	}
}
