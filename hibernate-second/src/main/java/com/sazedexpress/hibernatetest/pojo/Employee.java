package com.sazedexpress.hibernatetest.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="Employee_info")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empId")
	private int emp_id;
	
	@Column(name = "empName",nullable = false) //"nullable = false)" is used for "not null==true" in database
	private String emp_name;
	
	@Column(name="empMobile")
	private String emp_mobile;
	
	//@Transient  // "@Transient is used for not inseting a value into a specifi column"
	@Column(name="empAddress")
	private String emp_address;

	@Temporal(TemporalType.DATE)
	@Column(name="empdob")
	private Date dobDate;
	
	@OneToMany
	@JoinTable(name="employee_info_role",joinColumns = 
	@JoinColumn(name="emp_id"),inverseJoinColumns = 
	@JoinColumn(name="roleId"))
	private Collection<EmployeeRole> employeeRoles=new ArrayList<EmployeeRole>();
	
	
	public Collection<EmployeeRole> getEmployeeRoles() {
		return employeeRoles;
	}

	public void setEmployeeRoles(Collection<EmployeeRole> employeeRoles) {
		this.employeeRoles = employeeRoles;
	}

	public Date getDobDate() {
		return dobDate;
	}

	public void setDobDate(Date dobDate) {
		this.dobDate = dobDate;
	}

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

	public String getEmp_mobile() {
		return emp_mobile;
	}

	public void setEmp_mobile(String emp_mobile) {
		this.emp_mobile = emp_mobile;
	}

	public String getEmp_address() {
		return emp_address;
	}

	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_mobile=" + emp_mobile + ", emp_address="
				+ emp_address + ", dobDate=" + dobDate + "]";
	}

	
	
	
	
	
	

}
