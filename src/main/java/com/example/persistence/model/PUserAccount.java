package com.example.persistence.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class PUserAccount extends PAbstractEntity {
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public PUserAccount() {
		super();
	}

	public PUserAccount(final String firstName, final String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%s, firstName='%s', lastName='%s']", id, firstName, lastName);
	}
}
