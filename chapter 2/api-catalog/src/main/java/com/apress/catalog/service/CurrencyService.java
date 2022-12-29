package com.apress.catalog.service;

import org.springframework.stereotype.Service;

import com.apress.catalog.dto.CurrencyDTO;

@Service
public class CurrencyService {

	public CurrencyDTO getById(Long id) {
		return new CurrencyDTO(id, "USD", "Dollar", true, 2);
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
