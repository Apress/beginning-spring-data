package com.apress.catalog.model;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;
import java.io.Serializable;
import java.util.Objects;

@UserDefinedType("currency")
public class Currency implements Serializable {

	private String code;

	private String symbol;

	private String description;

	private Boolean enabled = Boolean.TRUE;

	private int decimalPlaces;

	private String countryId;

	public Currency() {}
	
	public Currency(String code, String description, Boolean enabled, int decimalPlaces, String symbol) {
		this.code = code;
		this.description = description;
		this.enabled = enabled;
		this.decimalPlaces = decimalPlaces;
		this.symbol = symbol;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}
	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	public int getDecimalPlaces() {
		return decimalPlaces;
	}
	
	public void setDecimalPlaces(int decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Currency currency = (Currency) o;
		return decimalPlaces == currency.decimalPlaces && Objects.equals(code, currency.code) && Objects.equals(symbol, currency.symbol) && Objects.equals(description, currency.description) && Objects.equals(enabled, currency.enabled) && Objects.equals(countryId, currency.countryId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, symbol, description, enabled, decimalPlaces, countryId);
	}
}
