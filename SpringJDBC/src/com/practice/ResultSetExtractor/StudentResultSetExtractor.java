package com.practice.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.practice.student.Student;

public class StudentResultSetExtractor implements ResultSetExtractor<List<Student>>{

	@Override
	public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		List<Student> studentList=new ArrayList<Student>();
		while (rs.next()) {
			Student student=new Student();
			student.setStudent_id(rs.getInt("student_id"));
			student.setStudent_name(rs.getString("student_name"));
			student.setStudent_dept(rs.getString("student_dept"));
			student.setStudent_address(rs.getString("student_addess"));
			student.setStudent_email(rs.getString("student_email"));
			student.setStudent_contact(rs.getString("student_contact"));
			studentList.add(student);
		}
		
		System.out.println("This is Result set Extractor---->>>>");
		// TODO Auto-generated method stub
		return studentList;
	}

}
