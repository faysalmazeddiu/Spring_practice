package com.mazedexpress.sm.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mazedexpress.sm.api.Student;
import com.mazedexpress.sm.rowmapper.StudentRowMapper;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Student> loadStudent() {
		
		String sqlString="SELECT * FROM students";
		List<Student> theListOfStudent=jdbcTemplate.query(sqlString, new StudentRowMapper());
		return theListOfStudent;
	}

	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		
		String sqlString="INSERT INTO students(name,mobile,country) VALUES(?,?,?)";
		Object[] sqlParamObjects= {student.getNameString(),student.getMobile(),student.getCountry()};
		int numOfrowAffected=jdbcTemplate.update(sqlString, sqlParamObjects);
		if (numOfrowAffected==1) {
			System.out.println("1 record Inserted");
		}
		
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		String sqlString="SELECT * FROM students WHERE id = ?";
		Student student=jdbcTemplate.queryForObject(sqlString, new StudentRowMapper(), id);
		return student;
	}

	@Override
	public void updateStudentInfo(Student student) {
		// TODO Auto-generated method stub
		String sqlString="UPDATE students SET name=?, mobile=?, country=? WHERE id=?";
		int rowAffected=jdbcTemplate.update(sqlString, student.getNameString(),student.getMobile(),student.getCountry(),student.getId());
		if (rowAffected>0) {
			System.out.println("Data Updated");
		}else {
			System.out.println("Sorry ! please try again");
		}
		
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		String sqlString="DELETE FROM students WHERE id=?";
		int rowAffected=jdbcTemplate.update(sqlString, id);
		if (rowAffected>0) {
			System.out.println("Data Deleted");
		}else {
			System.out.println("Sorry ! please try again");
		}
	}

}
