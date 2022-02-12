package com.home.classes;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;



public class Student {
	
	private String studentNameString;
	private int studentId;
	private Course course;
	
	
	
	/*public Student(String studentNameString, int studentId, Course course) {
		
		this.studentNameString = studentNameString;
		this.studentId = studentId;
		this.course = course;
	}*/
	
	
	public String getStudentNameString() {
		return studentNameString;
	}
	
	
	public void setStudentNameString(String studentNameString) {
		this.studentNameString = studentNameString;
	}
	public int getStudentId() {
		return studentId;
	}
	
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public Course getCourse() {
		return course;
	}
	
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public void displayCourseInfo() {
		
		System.out.println("Method from Student classes");
		System.out.println("The Student id is = "+studentId+" Student  name = "+studentNameString);
		course.displayCourseInfo();
		
		
	}
	

}
