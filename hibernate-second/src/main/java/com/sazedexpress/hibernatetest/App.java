package com.sazedexpress.hibernatetest;

import java.util.Date;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sazedexpress.hibernatetest.pojo.Employee;
import com.sazedexpress.hibernatetest.pojo.EmployeeRole;
import com.sazedexpress.hibernatetest.pojo.EmployeeSalary;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory =new Configuration()
       				.configure("hibernate.cfg.xml")
       				.addAnnotatedClass(Employee.class)
       				.buildSessionFactory();
    	
    	Session session = sessionFactory.openSession();
    	
    	// employee object
	    Employee employee=new Employee();	
		employee.setEmp_name(" Salam Ahamed Durjoy");
	    employee.setEmp_mobile("1234567");
	    employee.setEmp_address("USA");
	    employee.setDobDate(new Date());
	    
	    
	    // EmployeeRole object
	    EmployeeRole role=new EmployeeRole();
	    role.setRoleName("ADMIN");
	    EmployeeRole role2=new EmployeeRole();
	    role2.setRoleName("SuperAdmin");
	    
	    employee.getEmployeeRoles().add(role);
	    employee.getEmployeeRoles().add(role2);
	    
	    // EmployeeSalary object
	    EmployeeSalary employeeSalary=new EmployeeSalary();
	    employeeSalary.setSalary(50000);
	    employeeSalary.setEmployee(employee);
    		
    	session.beginTransaction();
    	
    	// for saving data
    	
    	session.save(employee);
    	session.save(role);
    	session.save(role2);
    	session.save(employeeSalary);
    	// for featch data by id
    	//Employee employeeinf=session.get(Employee.class,2);
    	
    	
    	// update record
    	/*
    	employeeinf.setEmp_address("Indonasia");
    	employeeinf.setEmp_mobile("+125678");
    	session.update(employeeinf);
    	*/
    	
    	// delete data
    	
    	//Employee employeeupdatedinf=session.get(Employee.class,2);
    	//session.delete(employeeupdatedinf);
    	
    	
    	// featch all data
    	org.hibernate.query.Query<Employee> query=session.createQuery("FROM Employee",Employee.class);
    	List<Employee> employeeList=query.getResultList();
    	for (Employee employeeinfo:employeeList) {
			System.out.println(employeeinfo);
		}
    	
    	
    	session.getTransaction().commit();
    	session.close();
       
    }
}
