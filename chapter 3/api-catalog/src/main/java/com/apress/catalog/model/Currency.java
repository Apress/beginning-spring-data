package com.apress.catalog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "currency") //Optional only if you need to indicate the table's name
public class Currency implements Serializable {
	
	@Id //Identify which is the primary key
	@GeneratedValue(strategy = GenerationType.SEQUENCE) //Indicate the way to generate the ID
	private Long id;
	
	private String code;
	private String description;
	private Boolean enabled;
	
	@Column(name = "decimal_places") //Optional: Indicate the name and the length of the column
	private int decimalPlaces;
	
	public Currency() {}
	
	public Currency(Long id, String code, String description, Boolean enabled, int decimalPlaces) {
		this.id = id;
		this.code = code;
		this.description = description;
		this.enabled = enabled;
		this.decimalPlaces = decimalPlaces;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Currency currency = (Currency) o;
		return decimalPlaces == currency.decimalPlaces && Objects.equals(id, currency.id) && Objects.equals(code, currency.code) && Objects.equals(description, currency.description) && Objects.equals(enabled, currency.enabled);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, code, description, enabled, decimalPlaces);
	}
}
