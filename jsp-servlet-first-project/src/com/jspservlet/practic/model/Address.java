package com.jspservlet.practic.model;

import java.util.ArrayList;

public class Address {
	
	private String city;
	private String zip_code;
	private String road_no;
	private ArrayList<Phone> phone;
	
	
	public Address() {
		
	}
	
	public Address(String city,String zip_code,String road_no,ArrayList<Phone> phone) {
		this.city=city;
		this.zip_code=zip_code;
		this.road_no=road_no;
		this.phone=phone;
		
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getRoad_no() {
		return road_no;
	}

	public void setRoad_no(String road_no) {
		this.road_no = road_no;
	}

	public ArrayList<Phone> getPhone() {
		return phone;
	}

	public void setPhone(ArrayList<Phone> phone) {
		this.phone = phone;
	}

	
	
	

}
