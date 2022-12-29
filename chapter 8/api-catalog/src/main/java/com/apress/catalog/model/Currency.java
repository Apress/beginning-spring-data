package com.apress.catalog.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;


@Document(value = "currency")
public class Currency extends Base implements Serializable {

	@NotBlank(message = "Code is mandatory")
	private String code;

	@NotBlank(message = "Symbol is mandatory")
	private String symbol;

	@NotBlank(message = "Description is mandatory")
	private String description;
	@NotNull(message = "The state of the currency is mandatory")
	private Boolean enabled = Boolean.TRUE;

	@Min(value = 1, message = "The minimum value is 1")
	@Max(value = 5 , message = "The maximum value is 5")
	private int decimalPlaces;

	public Currency() {}
	
	public Currency(Long id, String code, String description, Boolean enabled, int decimalPlaces, String symbol) {
		super(id);
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Currency currency = (Currency) o;
		return decimalPlaces == currency.decimalPlaces && Objects.equals(code, currency.code) && Objects.equals(symbol, currency.symbol) && Objects.equals(description, currency.description) && Objects.equals(enabled, currency.enabled);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), code, symbol, description, enabled, decimalPlaces);
	}
}
