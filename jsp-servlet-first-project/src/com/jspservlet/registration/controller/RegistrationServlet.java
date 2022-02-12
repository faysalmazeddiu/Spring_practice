package com.jspservlet.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspservlet.registration.dao.RegistrationDao;
import com.jspservlet.registration.model.Registration;



/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     RegistrationDao registrationDao=new RegistrationDao();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/Registration.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Registration registration=new Registration();
		registration.setFirst_name(request.getParameter("first_name"));
		registration.setLast_name(request.getParameter("last_name"));
		registration.setUsername(request.getParameter("username"));
		registration.setPassword(request.getParameter("password"));
		registration.setAddress(request.getParameter("address"));
		registration.setContact(request.getParameter("contact"));
		try {
			registrationDao.register(registration);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/successful.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/Registration.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
	}

}
