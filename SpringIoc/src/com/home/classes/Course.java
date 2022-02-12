package com.home.classes;

public class Course {
	
	private String courseId;
	private String courseName;
	
	
	
			 public Course(String courseId, String courseName) {
			 
				this.courseId = courseId;
				this.courseName = courseName;
			}
	
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public void displayCourseInfo() {
		
		System.out.println("Method from course classes");
		System.out.println("The course id is = "+courseId+" course name ="+courseName);
		
	}
	

}
