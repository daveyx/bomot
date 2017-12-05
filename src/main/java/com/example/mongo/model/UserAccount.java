package com.example.mongo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserAccount extends AbstractEntity {
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public UserAccount() {
		super();
	}

	public UserAccount(final String firstName, final String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%s, firstName='%s', lastName='%s']", id, firstName, lastName);
	}
}
