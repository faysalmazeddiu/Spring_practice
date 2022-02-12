package com.mazedexpress.sm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mazedexpress.sm.api.Student;


public interface StudentService {
	
	List<Student> loadStudent();
	void saveStudent(Student student);
	Student getStudentById(int id);
	void updateStudentInfo(Student student);
	void deleteStudent(int id);

}
