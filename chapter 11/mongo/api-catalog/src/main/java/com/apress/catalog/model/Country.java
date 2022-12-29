package com.apress.catalog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Document(value = "country")
public class Country implements Serializable {
	@Id
	private Long id;

	@Indexed
	@Field(value = "code")
	private String code;

	private String name;

	private String locale;

	private String timezone;

	private Boolean enabled = Boolean.TRUE;

	@DBRef
	private Currency currency;


	private List<State> states;

	public Country() {}

	public Country(Long id, String code, String name, String locale, String timezone, Boolean enabled, Currency currency, List<State> states) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.locale = locale;
		this.timezone = timezone;
		this.enabled = enabled;
		this.currency = currency;
		this.states = states;
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

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Country country = (Country) o;
		return Objects.equals(id, country.id) && Objects.equals(code, country.code) && Objects.equals(name, country.name) && Objects.equals(locale, country.locale) && Objects.equals(timezone, country.timezone) && Objects.equals(enabled, country.enabled) && Objects.equals(currency, country.currency) && Objects.equals(states, country.states);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, code, name, locale, timezone, enabled, currency, states);
	}
}
