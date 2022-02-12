package com.home.javabasedannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//import com.home.classes.Course;

@Component("studentObj")  //To create a bean object with a a specific name


//@Component() 
//it will create a bean object. object name will the based on class name but first letter will 
//    be converted into small letter Example-  Student---->student
public class Student {
	
	
	//@Value("Hiron Ahemed")
	@Value("${student.name}")
	private String studentNameString;
	
	private Course course;
	
	private Teacher teacher;
	
	

	public Course getCourse() {
		return course;
	}

	@Autowired
	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}
	
	
	@Autowired
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
    public void getStudentInfo() {
		
    	System.out.println("Student Name "+studentNameString);
		System.out.println("Here is student info");
		course.getClassInfo();
		teacher.techerInfo();
		
	}
	

}
