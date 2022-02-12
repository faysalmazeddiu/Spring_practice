package com.mazedexpress.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazedexpress.sm.DAO.StudentDAO;
import com.mazedexpress.sm.api.Student;
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentDAO studentDAO;
	@Override
	public List<Student> loadStudent() {
		// TODO Auto-generated method stub
		return studentDAO.loadStudent();
	}

	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		
		// business logic writting for email sending
		if (student.getCountry().equals("UK")) {
			System.out.println("The email is send to "+student.getNameString());
		}
		studentDAO.saveStudent(student);
		
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		Student student=studentDAO.getStudentById(id);
		return student;
	}

	@Override
	public void updateStudentInfo(Student student) {
		// TODO Auto-generated method stub
		studentDAO.updateStudentInfo(student);
		
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentDAO.deleteStudent(id);
		//return 0;
	}

}
