package com.example.mongo.model;

public class Customer extends AbstractEntity {
	public String firstName;
	public String lastName;

	public Customer() {
	}

	public Customer(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%s, firstName='%s', lastName='%s']", id, firstName, lastName);
	}
}
