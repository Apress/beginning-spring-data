package com.apress.catalog.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.io.Serializable;
import java.util.Objects;

@Node("State")
public class State implements Serializable {
	@Id
	private Long id;

	private String code;

	private String name;

	private Boolean enabled = Boolean.TRUE;

	private @Relationship Country country;

	public State() {}

	public State(Long id, String code, String name, Boolean enabled, Country country) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.enabled = enabled;
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		State state = (State) o;
		return Objects.equals(id, state.id) && Objects.equals(code, state.code) && Objects.equals(name, state.name) && Objects.equals(enabled, state.enabled) && Objects.equals(country, state.country);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, code, name, enabled, country);
	}
}
