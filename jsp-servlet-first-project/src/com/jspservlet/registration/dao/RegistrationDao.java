package com.jspservlet.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jspservlet.registration.model.Registration;

public class RegistrationDao {
	Connection con=null;
	PreparedStatement prepairStatement=null;
	public RegistrationDao() {
		con=DBConnection.dbConnection();
	}
	
	public int register(Registration registration) {
		System.out.println(registration);
		int result=0;
		//Connection con=dbConnection();
		String sqlQueryString="INSERT INTO registration"+
		"(first_name, last_name, username, password, address, contact) VALUES (?,?,?,?,?,?)";
		try {
			prepairStatement=con.prepareStatement(sqlQueryString);
			prepairStatement.setString(1, registration.getFirst_name());
			prepairStatement.setString(2, registration.getLast_name());
			prepairStatement.setString(3, registration.getUsername());
			prepairStatement.setString(4, registration.getPassword());
			prepairStatement.setString(5, registration.getAddress());
			prepairStatement.setString(6, registration.getContact());
			result=prepairStatement.executeUpdate();
			if (result>0) {
				String selectQueryString="SELECT id AS userId FROM registration ORDER BY id DESC LIMIT 1";
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(selectQueryString);
				int userId=0;
				if (rs.next()) {
					userId=rs.getInt("userId");
				}
				saveLoginInlfo(userId,registration.getUsername(),registration.getPassword());
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
		
	}
	
	public int saveLoginInlfo(int userId,String username,String password) {
		System.out.println(userId+"==="+username+"====="+password);
		String sqlQueryString="INSERT INTO login (user_id,username,password) VALUES(?,?,?)";
		int result=0;
		try {
			prepairStatement=con.prepareStatement(sqlQueryString);
			prepairStatement.setInt(1, userId);
			prepairStatement.setString(2, username);
			prepairStatement.setString(3, password);
			result=prepairStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
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
