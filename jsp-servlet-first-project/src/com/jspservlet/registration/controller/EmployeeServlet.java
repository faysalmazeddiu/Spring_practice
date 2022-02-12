package com.jspservlet.registration.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspservlet.registration.dao.EmployeeDao;
import com.jspservlet.registration.model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
//@WebServlet("/EmployeeServlet")
@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDao employeeDao=new EmployeeDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action=request.getServletPath();
		System.out.println(action);
		switch(action) {
		
			case "/new":
				showNewForm(request,response);
				break;
			case "/insert":
				insertEmployee(request,response);
				break;
			case "/delete":
				deleteEmployee(request,response);
				break;
			case "/edit":
				showEditForm(request,response);
				break;
			case "/update":
				updateEmployee(request,response);
				break;
			default:
				listOfAlEmployee(request,response);
				break;
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
    private void showNewForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/new-employee.jsp");
		
		dispatcher.forward(request, response);
		
	}
	
	private void insertEmployee(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
			Employee employee=new Employee();
			employee.setEmp_name(request.getParameter("emp_name"));
			employee.setEmp_mobile(request.getParameter("emp_mobile"));
			employee.setEmp_addres(request.getParameter("emp_addres"));
			employee.setEmp_email(request.getParameter("emp_email"));
			try {
				if (employeeDao.saveEmployee(employee)) {
					System.out.println("Data Save Successfully");
				}
			} catch (Exception e) {
				System.out.println("Sorry Something wrong. Please try again");
			}
			response.sendRedirect("employeelist");
			
	} 
	
	private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		int emp_id=Integer.parseInt(request.getParameter("empId"));
		Employee employee=employeeDao.getEmployeeById(emp_id);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/edit-employee.jsp");
		request.setAttribute("employee_info", employee);
		dispatcher.forward(request, response);
		
	}
	
	private void updateEmployee(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		Employee employee=new Employee();
		employee.setEmp_id(Integer.parseInt(request.getParameter("emp_id")));
		employee.setEmp_name(request.getParameter("emp_name"));
		employee.setEmp_mobile(request.getParameter("emp_mobile"));
		employee.setEmp_addres(request.getParameter("emp_addres"));
		employee.setEmp_email(request.getParameter("emp_email"));
		try {
			if (employeeDao.updateEmployee(employee)) {
				System.out.println("Data Updated Successfully");
			}
		} catch (Exception e) {
			System.out.println("Sorry Something wrong. Please try again");
		}
		response.sendRedirect("employeelist");
		
		
	}
	
	private void listOfAlEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> employeeList=employeeDao.getAllEmployee();
		System.out.println("+++++++++++++++++++++++++++++++++++");
		request.setAttribute("allEmployee", employeeList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/employee-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int emp_id=Integer.parseInt(request.getParameter("empId"));
		employeeDao.deleteEmployee(emp_id);
		response.sendRedirect("employeelist");
		
	}

}
