package com.apress.catalog.service;

import com.apress.catalog.dto.CountryDTO;
import com.apress.catalog.model.Country;
import com.apress.catalog.repository.CountryRepository;
import com.apress.catalog.repository.StateRepository;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CountryServiceTest {

    private CountryService service;
    private CountryRepository countryRepository;
    private StateRepository stateRepository;
    private Validator validator;

    @BeforeEach
    public void setUp() {
        countryRepository = mock(CountryRepository.class);
        stateRepository = mock(StateRepository.class);
        validator = mock(Validator.class);

        service = new CountryService(countryRepository, stateRepository, validator);
    }

    @Test
    public void should_save_a_country() {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setEnabled(Boolean.TRUE);
        countryDTO.setCode("ARG");
        countryDTO.setName("Argentina");

        Country country = new Country();
        when(countryRepository.save(any())).thenReturn(country);

        assertNotNull(service.save(countryDTO));
    }
}
