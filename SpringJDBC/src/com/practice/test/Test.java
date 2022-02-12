package com.practice.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.DAO.StudentDAO;
import com.practice.DAO.StudentDAOImpl;
import com.practice.helpers.StudentDAOHelper;
import com.practice.student.Student;

public class Test {
	
	public static void main(String[] args) {
		
		
		
		//ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		
		
		
		/*
		 
		Student newStudent=new Student();
		newStudent.setStudent_id(204);
		newStudent.setStudent_name("Abilas");
		newStudent.setStudent_email("obilas@gmail.com");
		
		newStudent.setStudent_dept("SWE");
		newStudent.setStudent_contact("01811625855");
		newStudent.setStudent_address("India");
		 
		 */
		
		
		
		
		StudentDAOHelper studentDAOHelper=context.getBean("studentDAOHelper",StudentDAOHelper.class);
		//studentDAOHelper.setUpStudentTable();
		StudentDAO studentDAO=context.getBean("studentOBJ",StudentDAOImpl.class);
		
	    System.out.println("Featching all information form database---->>>\n");
		List<Student> studentList=studentDAO.findAllStudent();
		studentDAOHelper.printStudent(studentList);
		
		System.out.println("Featching  information form database by student id---->>>\n\n");
		Student student=studentDAO.findStudentById(501);
		System.out.println(student);
		
		System.out.println("Featching  information form database by student dept using Result Extractor--->>>\n\n");
		List<Student> studentList2=studentDAO.findStudentByDept("EEE");
		studentDAOHelper.printStudent(studentList2);
		System.out.println("Featching  information form database by student dept group wise using Result Extractor--->>>\n\n");
		Map<String, List<String>> studentTable=studentDAO.groupStudentByDept();
		System.out.println(studentTable);
		
		
		System.out.println(" \n");
		System.out.println(" update student info-->>>\n\n");
		
		/*
		// for update record by id (single record update)
		 
		 
		System.out.println(" \n");
		System.out.println(" update student info-->>>\n\n");
		Student mazed=new Student();
		mazed.setStudent_id(101);
		mazed.setStudent_dept("BBA");
		studentDAO.updateStudentInf(mazed);
		
		*/
		
		
		
		System.out.println(" \n");
		System.out.println(" update student info batch wise ---->>>\n\n");
		Student mazed=new Student();
		mazed.setStudent_id(101);
		mazed.setStudent_dept("IT22");
		
		Student imran=new Student();
		imran.setStudent_id(501);
		imran.setStudent_dept("MEDICAL222");
		
		Student helal=new Student();
		helal.setStudent_id(504);
		helal.setStudent_dept("POLITICAL SCIENCE222");
		
		List<Student> studentListforUpdateList=new ArrayList<Student>();
		studentListforUpdateList.add(mazed);
		studentListforUpdateList.add(imran);
		studentListforUpdateList.add(helal);
		int rowAffected=studentDAO.updateStudentInfoByBatchWise(studentListforUpdateList);
		System.out.println(rowAffected+" number of rows affcted");
		
		//studentDAO.insert(newStudent);
		
		/*
			boolean isDeleted=studentDAO.deleteRecordByRegId(102);
			if (isDeleted) {
				System.out.println("the student id 2 is deleted--->>");
			}
			
		*/
		
		//studentDAO.deleteRecordByNameOrMobileNumber("hossain", "0171277909");
		//studentDAO.insertBatchData(student);
		
		//StudentDAO studentDAO=new StudentDAOImpl();
		//studentDAO.insert(newStudent);
		
		context.close();
		
	}

}
