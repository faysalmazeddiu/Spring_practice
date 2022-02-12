package com.jspservlet.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public static Connection dbConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/JspServletDB?useSSL=false","root","12345678");
			System.out.println("Connection Established");
			
		} catch (Exception e) {
			System.out.println("Sorry !!!! Connection not Established"+e.getMessage());
			
		}
		return connection;
	}

}
