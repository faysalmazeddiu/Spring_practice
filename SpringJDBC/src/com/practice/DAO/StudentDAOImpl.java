package com.practice.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

//import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practice.ResultSetExtractor.GroupStudentResultSetExtractor;
import com.practice.ResultSetExtractor.StudentResultSetExtractor;
import com.practice.rowmapper.StudentRowMapper;
import com.practice.student.Student;

@Repository("studentOBJ")  // @repository annotation also work as like as @Component annotation, which actually create bean object.  
public class StudentDAOImpl implements StudentDAO{
	
	//private JdbcTemplate jdbcTemplete=new JdbcTemplate(getDataSource());
	
	private JdbcTemplate jdbcTemplete;
	

	@Autowired
	public void setJdbcTemplete(JdbcTemplate jdbcTemplete) {
		this.jdbcTemplete = jdbcTemplete;
	}





	@Override
	public void insert(Student student) {
		// TODO Auto-generated method stub
		
		String sql="INSERT INTO student VALUES(?,?,?,?,?,?)";
		Object[] objectArray= {student.getStudent_id(),student.getStudent_name(),student.getStudent_dept(),student.getStudent_address(),student.getStudent_email(),student.getStudent_contact()};
		int noOfRow=jdbcTemplete.update(sql,objectArray);
		System.out.println("Number of row inserted into Database is "+noOfRow);
	}





	@Override
	public boolean deleteRecordByRegId(int regId) {
		// TODO Auto-generated method stub
		String deleteSqlQuery="DELETE FROM student WHERE student_id = ?";
		int numberOfRowDeleted=jdbcTemplete.update(deleteSqlQuery,regId);
		if (numberOfRowDeleted==1) {
			System.out.println("the student id "+regId+" is deleted--->>");
		}
		
		return numberOfRowDeleted==1;
	}





	@Override
	public int deleteRecordByNameOrMobileNumber(String studentName, String mobileNumber) {
		// TODO Auto-generated method stub
		String sqlQuery="DELETE FROM student WHERE student_name= ? OR student_contact= ? ";
		Object[] args= {studentName,mobileNumber};
		int numberOfRowDeleted=jdbcTemplete.update(sqlQuery, args);
		System.out.print(" The number of row deleted-----> "+numberOfRowDeleted);
		return numberOfRowDeleted;
	}





	@Override
	public void insertBatchData(List<Student> student) {
		// TODO Auto-generated method stub
		
		String sqlString="INSERT INTO student VALUES(?,?,?,?,?,?)";
		ArrayList<Object[]> batchArgs=new ArrayList<>();
		for(Student tempStudent:student) {
			Object[] studentObjects = {tempStudent.getStudent_id(),tempStudent.getStudent_name(),tempStudent.getStudent_dept(),tempStudent.getStudent_address(),tempStudent.getStudent_email(),tempStudent.getStudent_contact()};
			batchArgs.add(studentObjects);
		}
		jdbcTemplete.batchUpdate(sqlString, batchArgs);
		System.out.println("Data inserted successfully with batch");
		//return 0;
	}





	@Override
	public List<Student> findAllStudent() {
		// TODO Auto-generated method stub
		String sqlString="SELECT * FROM student";
		List<Student> studentList=jdbcTemplete.query(sqlString, new StudentRowMapper());
		return studentList;
	}





	@Override
	public Student findStudentById(int student_id) {
		// TODO Auto-generated method stub
		//String sqString="SELECT * FROM student WHERE student_id= ? ";  // it works successfully
		//Student student=jdbcTemplete.queryForObject(sqString, new StudentRowMapper(),student_id); // it works successfully
		
		// alies making process <table column AS property name>
		String sqString="SELECT student_id as student_id, student_name as student_name, student_dept as student_dept, student_addess as student_address,student_email as student_email, student_contact as student_contact FROM student WHERE student_id= ? ";
		Student student=jdbcTemplete.queryForObject(sqString, new BeanPropertyRowMapper<Student>(Student.class),student_id); 
		return student;
	}





	@Override
	public List<Student> findStudentByDept(String studentDept) {
		
		String sqlString="SELECT * FROM student WHERE student_dept = ? ";
		List<Student>studentList=jdbcTemplete.query(sqlString, new StudentResultSetExtractor(),studentDept);
		// TODO Auto-generated method stub
		return studentList;
	}





	@Override
	public Map<String, List<String>> groupStudentByDept() {
		// TODO Auto-generated method stub
		
		String sqlString="SELECT * FROM student";
		Map<String, List<String>> studentGroup=jdbcTemplete.query(sqlString, new GroupStudentResultSetExtractor());
		return studentGroup;
	}





	@Override
	public int updateStudentInf(Student student) {
		// TODO Auto-generated method stub
		String sqlString="UPDATE StudentDb.student SET student_dept = ? WHERE student_id = ?";
		Object[] args= {student.getStudent_dept(),student.getStudent_id()};
		int rowAffected=jdbcTemplete.update(sqlString, args);
		System.out.println("-->Student info updated row-->>"+rowAffected);
		return rowAffected;
	}
	
	
	//  @Transactional   annotation help query for rool backing data when any exception occure at middle position of query execution
	@Transactional  
	public int updateStudentInfoByBatchWise(List<Student> studentsList) {
		int countNumberOfRowAffected=0;
		String sqlString="UPDATE StudentDb.student SET student_dept = ? WHERE student_id = ?";
		int[] rowAffected=jdbcTemplete.batchUpdate(sqlString, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int index) throws SQLException {
				// I need to set args for prepare statement
				ps.setString(1, studentsList.get(index).getStudent_dept());
				ps.setInt(2, studentsList.get(index).getStudent_id());
				
				System.out.println("Caling setValues and updated value 1 by 1");
				
			}
			
			@Override
			public int getBatchSize() {
				// in this method we have to define how many time our query will be executed
				// How many time setValue method will be executed
				System.out.println("Get List size");
				return studentsList.size();
			}
		});
		
		for (int i = 0; i < rowAffected.length; i++) {
			if(rowAffected[i]==1) {
				countNumberOfRowAffected++;
			}
		}
		
		return countNumberOfRowAffected;
		
	}
	
	/*
	public DataSource getDataSource() {
		
		String url="jdbc:mysql://localhost:3306/StudentDb?useSSL-false";
		String username="root";
		String password="12345678";
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	*/

}
