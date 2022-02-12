package com.jspservlet.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jspservlet.registration.model.Login;

public class LoginDao {
	
	Connection connection=null;
	Statement stmtStatement=null;
	PreparedStatement prepairStatement=null;
	public LoginDao() {
		connection=DBConnection.dbConnection();
		
	}
	public Login checkLogin(Login login) {
		System.out.println(login);
		//boolean status=false;
		Login loginData= new Login();
		String sqlQueryString="SELECT * FROM login WHERE username=? and password=?";
		try {
			prepairStatement=connection.prepareStatement(sqlQueryString);
			prepairStatement.setString(1, login.getUsername());
			prepairStatement.setString(2, login.getPassword());
			ResultSet rs=prepairStatement.executeQuery();
			if (rs.next()) {
				loginData.setLogin_id(rs.getInt("login_id"));
				loginData.setUser_id(rs.getInt("user_id"));
				loginData.setUsername(rs.getString("username"));
				loginData.setPassword(rs.getString("password"));
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(loginData+"wertyuio");
		return loginData;
	}
	
	/*
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
	*/

}
