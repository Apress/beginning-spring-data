package com.apress.catalog.dto;

import java.io.Serializable;

public class StateDTO implements Serializable {
	private Long id;

	private String code;
	private String name;
	private Boolean enabled;

	private CountryDTO country;

	public StateDTO() {}

	public StateDTO(Long id, String code, String name, Boolean enabled, CountryDTO country) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.enabled = enabled;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public CountryDTO getCountry() {
		return country;
	}

	public void setCountry(CountryDTO country) {
		this.country = country;
	}
}
