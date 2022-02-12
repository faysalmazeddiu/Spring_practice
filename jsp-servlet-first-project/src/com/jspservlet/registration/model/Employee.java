package com.jspservlet.registration.model;

public class Employee {
	
	private int emp_id;
	private String emp_name;
	private String emp_email;
	private String emp_addres;
	private String emp_mobile;
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public String getEmp_addres() {
		return emp_addres;
	}
	public void setEmp_addres(String emp_addres) {
		this.emp_addres = emp_addres;
	}
	public String getEmp_mobile() {
		return emp_mobile;
	}
	public void setEmp_mobile(String emp_mobile) {
		this.emp_mobile = emp_mobile;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_email=" + emp_email + ", emp_addres="
				+ emp_addres + ", emp_mobile=" + emp_mobile + "]";
	}
	
	
	

}
