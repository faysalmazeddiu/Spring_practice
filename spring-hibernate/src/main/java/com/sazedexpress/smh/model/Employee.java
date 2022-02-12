package com.sazedexpress.smh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee_info")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="empId")
    private int emp_id;
	
	@Column(name ="empName")
	private String emp_name;
	
	@Column(name="empAddress")
	private String emp_address;
	
	@Column(name="empdob")
	private String emp_dob;
	
	@Column(name="empMobile")
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

	public String getEmp_address() {
		return emp_address;
	}

	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}

	public String getEmp_dob() {
		return emp_dob;
	}

	public void setEmp_dob(String emp_dob) {
		this.emp_dob = emp_dob;
	}

	public String getEmp_mobile() {
		return emp_mobile;
	}

	public void setEmp_mobile(String emp_mobile) {
		this.emp_mobile = emp_mobile;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_address=" + emp_address + ", emp_dob="
				+ emp_dob + ", emp_mobile=" + emp_mobile + "]";
	}

}
