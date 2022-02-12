package com.sazedexpress.hibernatetest.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class EmployeeSalary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int salary_info_id;
	private double salary;
	
	@OneToOne
	@JoinColumn(name="empId")
	private Employee employee;

	public int getSalary_info_id() {
		return salary_info_id;
	}

	public void setSalary_info_id(int salary_info_id) {
		this.salary_info_id = salary_info_id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeeSalary [salary_info_id=" + salary_info_id + ", salary=" + salary + ", employee=" + employee
				+ "]";
	}
	
	
	
	

}
