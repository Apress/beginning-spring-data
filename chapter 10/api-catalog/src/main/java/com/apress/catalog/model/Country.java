package com.apress.catalog.model;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Table("country")//It’s not the same package like JPA
public class Country implements Serializable {

	@PrimaryKeyColumn(
			name = "id",
			type = PrimaryKeyType.CLUSTERED,
			ordering = Ordering.DESCENDING)
	private UUID id = Uuids.timeBased();

	@PrimaryKeyColumn(
			name = "code",
			type = PrimaryKeyType.PARTITIONED,
			ordering = Ordering.DESCENDING)
	private String code;

	@Column
	private String name;

	@Column
	private String locale;

	@Column
	private String timezone;

	@Column
	private Boolean enabled = Boolean.TRUE;

	@Column("currency")
	private Currency currency;

	@Column("states")
	private List<State> states;

	public Country() {}

	public Country(UUID id, String code, String name, String locale, String timezone, Boolean enabled, Currency currency, List<State> states) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.locale = locale;
		this.timezone = timezone;
		this.enabled = enabled;
		this.currency = currency;
		this.states = states;
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
