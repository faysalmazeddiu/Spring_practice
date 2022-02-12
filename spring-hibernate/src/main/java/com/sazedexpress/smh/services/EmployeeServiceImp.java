package com.sazedexpress.smh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sazedexpress.smh.dao.EmployeeDAO;
import com.sazedexpress.smh.model.Employee;
@Service
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	private EmployeeDAO employeeDAO;
	
	
	@Override
	public String saveEmployee(Employee employee) {
		
		return employeeDAO.saveEmployee(employee);
	}

	@Override
	public Employee employeeInfoById(int empId) {
		
		return employeeDAO.employeeInfoById(empId);
	}

	@Override
	public List<Employee> employeesList() {
		// TODO Auto-generated method stub
		return employeeDAO.employeesList();
	}

	@Override
	public String deleteEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return employeeDAO.deleteEmployeeById(empId);
	}

	@Override
	public String updateEmployee(Employee employee) {
		
		return employeeDAO.updateEmployee(employee);
	}

}
