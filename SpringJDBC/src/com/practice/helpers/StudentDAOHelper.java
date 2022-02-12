package com.practice.helpers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.DAO.StudentDAO;
import com.practice.student.Student;


@Service("studentDAOHelper")  //  @Service annotation also work as like as @Component annotation, which actually create bean object.
public class StudentDAOHelper {
	
	@Autowired
	private StudentDAO studentDAOImplDao;
	
	public void setUpStudentTable() {
		
		Student student1=new Student();
		student1.setStudent_id(501);
		student1.setStudent_name("Imran Khan");
		student1.setStudent_email("imran@gmail.com");
		student1.setStudent_dept("EEE");
		student1.setStudent_contact("99999999");
		student1.setStudent_address("INDIA, KELKATA");
		
		
		Student student2=new Student();
		student2.setStudent_id(502);
		student2.setStudent_name("Rabin Khan");
		student2.setStudent_email("Rabin@gmail.com");
		student2.setStudent_dept("CSC");
		student2.setStudent_contact("777777");
		student2.setStudent_address("INDIA, PUNE");
		
		
		Student student3=new Student();
		student3.setStudent_id(503);
		student3.setStudent_name("Bella Khan");
		student3.setStudent_email("belal@gmail.com");
		student3.setStudent_dept("SWE");
		student3.setStudent_contact("66666666");
		student3.setStudent_address("SRILONKA, GIRO POINT");
		
		
		
		
		Student student4=new Student();
		student4.setStudent_id(504);
		student4.setStudent_name("Helal Khan");
		student4.setStudent_email("helal@gmail.com");
		student4.setStudent_dept("IT");
		student4.setStudent_contact("5555555");
		student4.setStudent_address("SRILONKA, GIRO POINT");
		
		ArrayList<Student> studentList=new ArrayList<Student>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		studentList.add(student4);
		studentDAOImplDao.insertBatchData(studentList);
		
		
		
		
	}
	
	public void printStudent(List<Student> studentList) {
		
		for (Student tempStudent:studentList) {
			System.out.println(tempStudent);
		}
		
	}

}
