package com.zilker.signupform.bean;

public class Details {
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String username;
	
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
	public String getUername() {
		return username;
	}
	public void setUsername(String address) {
		this.username = username;
	}
	public Details(String firstName, String lastName, String email, String phone, String username) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.username = username;
	}
	
}
