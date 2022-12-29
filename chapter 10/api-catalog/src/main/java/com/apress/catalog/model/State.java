package com.apress.catalog.model;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.io.Serializable;
import java.util.Objects;

@UserDefinedType("state")
public class State implements Serializable {
	private Long id;

	private String code;

	private String name;

	private Boolean enabled = Boolean.TRUE;

	private String countryId;

	public State() {}

	public State(String code, String name, Boolean enabled) {
		this.code = code;
		this.name = name;
		this.enabled = enabled;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		State state = (State) o;
		return Objects.equals(id, state.id) && Objects.equals(code, state.code) && Objects.equals(name, state.name) && Objects.equals(enabled, state.enabled) && Objects.equals(countryId, state.countryId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, code, name, enabled, countryId);
	}
}
