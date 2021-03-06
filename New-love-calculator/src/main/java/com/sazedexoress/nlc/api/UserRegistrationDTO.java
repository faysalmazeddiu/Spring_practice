package com.sazedexoress.nlc.api;

import javax.validation.constraints.NotEmpty;

import com.sazedexoress.nlc.validator.Age;
import com.sun.org.glassfish.gmbal.ManagedAttribute;

public class UserRegistrationDTO {
	
	@NotEmpty(message=" * can not be null or Empty")
	private String name;
	private String userName;
	private char[] password;
	
	private String countryName;
	private String[] hobbies;
	private String gender;
	
	//@Age
	//@Age(lower=30, upper=75, message="the should be 30 to 75")
	@Age(lower=30, upper=75)
	private Integer age;
	
	private CommunicationDTO communicationDTO;
	
	
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public CommunicationDTO getCommunicationDTO() {
		return communicationDTO;
	}
	public void setCommunicationDTO(CommunicationDTO communicationDTO) {
		this.communicationDTO = communicationDTO;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	
	
}
