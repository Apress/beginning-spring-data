package com.apress.catalog.dto;


import java.util.List;
import java.util.UUID;

public class CountryDTO {
	private UUID id;
	private String code;
	private String name;
	private String locale;
	private String timezone;
	private Boolean enabled;

	private CurrencyDTO currency;

	private List<StateDTO> states;

	private Long version;

	public CountryDTO() {}

	public CountryDTO(UUID id, String code, String name, String locale, String timezone, Boolean enabled, CurrencyDTO currency) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.locale = locale;
		this.timezone = timezone;
		this.enabled = enabled;
		this.currency = currency;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public CurrencyDTO getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyDTO currency) {
		this.currency = currency;
	}

	public List<StateDTO> getStates() {
		return states;
	}

	public void setStates(List<StateDTO> states) {
		this.states = states;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
