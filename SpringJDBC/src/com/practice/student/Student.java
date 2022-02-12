package com.practice.student;

public class Student {
	
	private int student_id;
	private String student_name;
	private String student_dept;
	private String student_address;
	private String student_email;
	private String student_contact;
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
	public String getStudent_dept() {
		return student_dept;
	}
	public void setStudent_dept(String student_dept) {
		this.student_dept = student_dept;
	}
	public String getStudent_address() {
		return student_address;
	}
	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}
	public String getStudent_email() {
		return student_email;
	}
	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}
	public String getStudent_contact() {
		return student_contact;
	}
	public void setStudent_contact(String student_contact) {
		this.student_contact = student_contact;
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_dept=" + student_dept
				+ ", student_address=" + student_address + ", student_email=" + student_email + ", student_contact="
				+ student_contact + "]";
	}
	
	
	
	
}
