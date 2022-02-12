package com.home.classes;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Xml loded");
		Student student=context.getBean("studentObj",Student.class);
		student.displayCourseInfo();
		context.close();

	}

}
