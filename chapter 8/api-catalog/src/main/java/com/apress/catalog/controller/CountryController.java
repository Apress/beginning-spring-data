package com.apress.catalog.controller;

import com.apress.catalog.dto.CountryDTO;
import com.apress.catalog.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<CountryDTO>> getAll(@RequestParam String name) {
        List<CountryDTO> response = countryService.getAll(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<CountryDTO> getById(@PathVariable Long id) {
        CountryDTO response = countryService.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<CountryDTO> save(@RequestBody CountryDTO countryDTO) {
        CountryDTO response = countryService.save(countryDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<CountryDTO> update(@RequestBody CountryDTO countryDTO) {
        CountryDTO response = countryService.update(countryDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws InterruptedException {
        countryService.delete(id);
        return ResponseEntity.ok().build();
    }


}
