package com.jspservlet.practic.model;

public class Phone {
	
	private String country_code;
	private String main_digit;
	
	public Phone() {
		
	}
	public Phone(String cCode,String mDigit) {
		this.country_code=cCode;
		this.main_digit=mDigit;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getMain_digit() {
		return main_digit;
	}
	public void setMain_digit(String main_digit) {
		this.main_digit = main_digit;
	}
	
	

}
