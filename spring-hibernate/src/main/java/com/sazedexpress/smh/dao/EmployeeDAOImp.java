package com.sazedexpress.smh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sazedexpress.smh.model.Employee;
@Repository
//@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED) "delete operation does not work for this"
@Transactional
public class EmployeeDAOImp implements EmployeeDAO{

	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public String saveEmployee(Employee employee) {
		String messageString="";
		System.out.println(employee);
		Session session=sessionFactory.getCurrentSession();
		int rowAffected=(int)session.save(employee);
		if (rowAffected>0) {
			messageString="Data Saved Successfully";
		}else {
			messageString="Sorry !! Please try again";
		}
		return messageString;
	}

	@Override
	public Employee employeeInfoById(int empId) {
		
		Session session=sessionFactory.getCurrentSession();
		Employee employee=session.get(Employee.class, empId);
		return employee;
		
	}

	@Override
	public List<Employee> employeesList() {
		Session session=sessionFactory.getCurrentSession();
		Query<Employee> query=session.createQuery("FROM Employee",Employee.class);
		List<Employee> employeeList=query.getResultList();
		for (Employee employeeinfo:employeeList) {
			System.out.println(employeeinfo);
		}
		return employeeList;
	}

	@Override
	public String deleteEmployeeById(int empId) {
		String message="";
		Session session=sessionFactory.getCurrentSession();
		Employee employee=session.get(Employee.class, empId);
		try {
			session.delete(employee);
			message="Data Successfully Delete";
		} catch (Exception e) {
			message="Sorry Please try again";
		}
		
		
        return message;
	}

	@Override
	public String updateEmployee(Employee employee) {
		String message="";
		Session session=sessionFactory.getCurrentSession();
		Employee empinfo=session.get(Employee.class, employee.getEmp_id());
		empinfo.setEmp_name(employee.getEmp_name());
		empinfo.setEmp_address(employee.getEmp_address());
		empinfo.setEmp_dob(employee.getEmp_dob());
		empinfo.setEmp_mobile(employee.getEmp_mobile());
		try {
			session.update(empinfo);
			message="Data Successfully Updated";
		} catch (Exception e) {
			message="Sorry Please try again";
		}
		return message;
	}

}
