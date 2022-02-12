package com.home.javabasedannotation;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration  // To introduce this file as bean file while  xml is removed
@ComponentScan("com.home.javabasedannotation") // To create object for all classes inside the ApplicationContext
@PropertySource("classpath:service-info.properties")
public class BeanCofiguration {
	
	/*
	 
			//@Bean
			public Teacher teacherBean() {
				Teacher teacher=new MathTeacher();
				return teacher;
			}
			
			
			//@Bean
			public Course courseBean() {
				
				Course course=new Course();
				return course;
			}
			
			//@Bean
			@Bean("studentObj")    // for giving specific bean object name
			public Student studentBean() {   // by default method name will be beanObject
				
				Student student=new Student();
				student.setCourse(courseBean());   // injecting value by using setter method in Student object
				student.setTeacher(teacherBean());  // injecting value by using setter method  in Student object
				return student;
			}
	
	*/

}
