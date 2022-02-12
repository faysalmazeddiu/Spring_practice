package com.mazedexpress.sm.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mazedexpress.sm.api.Student;

public class StudentRowMapper  implements RowMapper<Student>{

	
	
	
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student studentObj=new Student();
		studentObj.setId(rs.getInt("id"));
		studentObj.setNameString(rs.getString("name"));
		studentObj.setMobile(rs.getLong("mobile"));
		studentObj.setCountry(rs.getString("country"));
		// TODO Auto-generated method stub
		return studentObj;
	}

}
