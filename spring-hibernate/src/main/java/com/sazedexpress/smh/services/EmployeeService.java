package com.sazedexpress.smh.services;

import java.util.List;

import com.sazedexpress.smh.model.Employee;

public interface EmployeeService {
	
	String saveEmployee(Employee employee);
	Employee employeeInfoById(int empId);
	List<Employee> employeesList();
	String deleteEmployeeById(int empId);
	String updateEmployee(Employee employee);
	
}
