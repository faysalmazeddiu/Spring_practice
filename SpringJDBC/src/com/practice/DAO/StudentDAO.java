package com.practice.DAO;

import java.util.List;
import java.util.Map;

import com.practice.student.Student;

public interface StudentDAO {
	
	  void insert(Student student);
	  void insertBatchData(List<Student> student);
	  boolean deleteRecordByRegId(int regId);
	  int deleteRecordByNameOrMobileNumber(String studentName,String mobileNumber);
	  List<Student> findAllStudent(); 
	  Student findStudentById(int student_id);
	  List<Student> findStudentByDept(String studentDept);
	  Map<String, List<String>> groupStudentByDept();
	  int updateStudentInf(Student student);
	  int updateStudentInfoByBatchWise(List<Student> studentsList);

}
