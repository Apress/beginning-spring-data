package com.apress.catalog.model;

import java.io.Serializable;
import java.util.Objects;

public class City implements Serializable {
	private Long id;
	private String name;
	private Boolean enabled;
	private State state;

	public City() {}

	public City(Long id, String name, Boolean enabled, State state) {
		this.id = id;
		this.name = name;
		this.enabled = enabled;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		City city = (City) o;
		return Objects.equals(id, city.id) && Objects.equals(name, city.name) && Objects.equals(enabled, city.enabled) && Objects.equals(state, city.state);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, enabled, state);
	}
}
