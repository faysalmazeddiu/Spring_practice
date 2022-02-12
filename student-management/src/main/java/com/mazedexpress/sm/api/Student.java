package com.mazedexpress.sm.api;


public class Student {
	
	private int id;
	private String nameString;
	private long mobile;
	private String country;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", nameString=" + nameString + ", mobile=" + mobile + ", country=" + country + "]";
	}
	 
	

}
