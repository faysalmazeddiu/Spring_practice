package com.jspservlet.practic.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BeanServlet
 */
@WebServlet("/BeanServlet")
public class BeanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Name name=new Name("Faysal","Mazed");
		ArrayList<Phone> phoneList=new ArrayList<Phone>();
		Phone phone=new Phone("+88", "01811625855");
		Phone phone2=new Phone("+88", "01715277909");
		phoneList.add(phone);
		phoneList.add(phone2);
		Address address=new Address("Dhaka", "1201", "101 Street, Bhasundhara", phoneList);
		StudentPractice studentPractice=new StudentPractice("faysalmazed@gmail.com", name, address);
		request.setAttribute("student", studentPractice);
		RequestDispatcher dispatcher=request.getRequestDispatcher("student-practice.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
