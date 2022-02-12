package com.jspservlet.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspservlet.registration.dao.LoginDao;
import com.jspservlet.registration.model.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao loginDao=new LoginDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/Login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Login login=new Login();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		login.setUsername(username);
		login.setPassword(password);
		try {
			//if (loginDao.checkLogin(login)) {
			   Login loginValue=loginDao.checkLogin(login);
			   System.out.println(loginValue+"===========");
			if(loginValue.getLogin_id()!=0 && loginValue.getUser_id()!=0) {
				HttpSession session=request.getSession();
				session.setAttribute("username", loginValue.getUsername());
				session.setAttribute("login_id", loginValue.getLogin_id());
				session.setAttribute("user_id", loginValue.getUser_id());
				//response.sendRedirect("WEB-INF/views/login-successfull.jsp");
				RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/login-successfull.jsp");
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/Login.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
//	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		
//		//RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/EmployeeRegistration.jsp");
//		//dispatcher.forward(request, response);
//		
	//}
	
	

}
