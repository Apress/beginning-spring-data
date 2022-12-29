package com.apress.catalog.service;

import com.apress.catalog.dto.CurrencyDTO;
import com.apress.catalog.mapper.ApiMapper;
import com.apress.catalog.model.Currency;
import com.apress.catalog.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyService {

	CurrencyRepository repository;
	
	@Autowired
	public CurrencyService(CurrencyRepository repository) {
		this.repository = repository;
	}
	
	public CurrencyDTO getById(Long id) {
		CurrencyDTO response = null;
		Optional<Currency> currency = repository.findById(id);
		
		if(currency.isPresent()) {
			response = ApiMapper.INSTANCE.entityToDTO(currency.get());
		}
		
		return response;
	}

	public CurrencyDTO save(CurrencyDTO currencyDTO) {
		return currencyDTO;
	}

	public CurrencyDTO update(CurrencyDTO currencyDTO) {
		return currencyDTO;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
	}
}
