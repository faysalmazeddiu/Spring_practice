package com.mazedexpress.sm.DAO;

import java.util.List;

import com.mazedexpress.sm.api.Student;

public interface StudentDAO {
	
	List<Student> loadStudent();
	void saveStudent(Student student);
	Student getStudentById(int id);
	void updateStudentInfo(Student student);
	void deleteStudent(int id);

}
