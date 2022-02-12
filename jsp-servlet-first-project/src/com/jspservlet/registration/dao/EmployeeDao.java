package com.jspservlet.registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jspservlet.registration.model.Employee;

public class EmployeeDao {
	
	Connection connection=null;
	Statement stmp= null;
	public EmployeeDao() {
		
		connection=DBConnection.dbConnection();
		
	}
	
	public boolean saveEmployee(Employee employee) throws SQLException {
		boolean status=false;
		String sqlQuery="INSERT INTO tbl_employee (emp_name, emp_email, emp_address, emp_mobile) VALUES(?,?,?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, employee.getEmp_name());
			preparedStatement.setString(2, employee.getEmp_email());
			preparedStatement.setString(3, employee.getEmp_addres());
			preparedStatement.setString(4, employee.getEmp_mobile());
			int result=preparedStatement.executeUpdate();
			if (result>0) {
				status=true;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
		
	}
	
	public boolean updateEmployee(Employee employee) throws SQLException {
		boolean status=false;
		String sqlQueryString="UPDATE tbl_employee SET emp_name=?, emp_email=?, emp_address=?, emp_mobile=? where emp_id=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sqlQueryString);
			preparedStatement.setString(1, employee.getEmp_name());
			preparedStatement.setString(2, employee.getEmp_email());
			preparedStatement.setString(3, employee.getEmp_addres());
			preparedStatement.setString(4, employee.getEmp_mobile());
			preparedStatement.setInt(5, employee.getEmp_id());
			int result=preparedStatement.executeUpdate();
			if (result>0) {
				status=true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	
	public Employee getEmployeeById(int emp_id) {
		Employee employee =null;
		String sqlQueryString="SELECT * FROM tbl_employee WHERE emp_id=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sqlQueryString);
			preparedStatement.setInt(1,emp_id);
			ResultSet rs=preparedStatement.executeQuery();
			if (rs.next()) {
				employee =new Employee();
				employee.setEmp_id(rs.getInt("emp_id"));
				employee.setEmp_name(rs.getString("emp_name"));
				employee.setEmp_email(rs.getString("emp_email"));
				employee.setEmp_addres(rs.getString("emp_address"));
				employee.setEmp_mobile(rs.getString("emp_mobile"));
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return employee;
	}
	
	public boolean deleteEmployee(int emp_id) {
		boolean status=false;
		String sqlString="DELETE from tbl_employee where emp_id=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setInt(1,emp_id);
			int result=preparedStatement.executeUpdate();
			if (result>0) {
				status=true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public List<Employee> getAllEmployee(){
		List<Employee> employeeList=null;
		String sqlString ="SELECT * FROM tbl_employee";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sqlString);
			System.out.println(preparedStatement);
			ResultSet rs=preparedStatement.executeQuery();
			
			//if (rs.next()) {
				employeeList=new ArrayList<Employee>();
				while (rs.next()) {
					Employee employee=new Employee();
					employee.setEmp_id(rs.getInt("emp_id"));
					employee.setEmp_name(rs.getString("emp_name"));
					employee.setEmp_email(rs.getString("emp_email"));
					employee.setEmp_addres(rs.getString("emp_address"));
					employee.setEmp_mobile(rs.getString("emp_mobile"));
					
					employeeList.add(employee);
				}
			//}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(employeeList);
		return employeeList;
	}

}
