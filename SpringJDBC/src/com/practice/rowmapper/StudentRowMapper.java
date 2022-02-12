package com.practice.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.practice.student.Student;

public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student newStudent=new Student();
		newStudent.setStudent_id(rs.getInt("student_id"));
		newStudent.setStudent_name(rs.getString("student_name"));
		newStudent.setStudent_dept(rs.getString("student_dept"));
		newStudent.setStudent_address(rs.getString("student_addess"));
		newStudent.setStudent_email(rs.getString("student_email"));
		newStudent.setStudent_contact(rs.getString("student_contact"));
		
		System.out.println("This is RowMapper---->>>>");
		// TODO Auto-generated method stub
		
		return newStudent;
	}

}
