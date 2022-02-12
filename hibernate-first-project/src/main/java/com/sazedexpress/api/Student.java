package com.sazedexpress.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int student_id;
	
	@Column(name="name")
	private String student_name;
	
	@Column(name="country")
	private String student_country;
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_country() {
		return student_country;
	}
	public void setStudent_country(String student_country) {
		this.student_country = student_country;
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_country="
				+ student_country + "]";
	}
	
	
	
	}

