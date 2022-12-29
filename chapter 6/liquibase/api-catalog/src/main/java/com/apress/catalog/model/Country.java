package com.apress.catalog.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity //This annotation indicates to JPA that it’s something that has a persistent state
@Table(name= "country") //This annotation is optionally
public class Country implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "code", nullable = false, length = 4)
	private String code;
	@Column(name = "name", nullable = false, length = 30)
	private String name;
	@Column(name = "locale", nullable = false, length = 6)
	private String locale;
	@Column(name = "time_zone", nullable = false)
	private String timezone;
	@Column(name = "enabled", nullable = false)
	private Boolean enabled = Boolean.TRUE;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "currency_id", nullable = false)
	private Currency currency;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id", nullable = false, updatable = false, insertable = false)
	@OrderBy(value = "code")
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
