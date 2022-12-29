package com.apress.catalog.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity //This annotation indicates to JPA that it’s something that has a persistent state
@Table(name= "state") //This annotation is optionally
public class State implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "code", nullable = false, length = 4)
	private String code;
	@Column(name = "name", nullable = false, length = 30)
	private String name;
	@Column(name = "enabled", nullable = false)
	private Boolean enabled = Boolean.TRUE;
	@ManyToOne
	@JoinColumn(name = "country_id", insertable = false, updatable = false)
	private Country country;

	public State() {}

	public State(Long id, String code, String name, Boolean enabled, Country country) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.enabled = enabled;
		this.country = country;
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
