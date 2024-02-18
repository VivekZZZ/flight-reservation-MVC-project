package com.jsp.flight_reservation_app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Passenger extends AbstractEntity {
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	private String middleName;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String phone;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
