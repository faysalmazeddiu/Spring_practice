package com.jspservlet.practic.model;

public class StudentPractice {
	private String email;
	private Name name;
	private Address address;
	
	public StudentPractice() {
		
	}
	
	public StudentPractice(String email, Name name, Address address) {
		//super();
		this.email = email;
		this.name = name;
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
