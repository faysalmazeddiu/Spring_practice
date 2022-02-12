package com.sazedexpress.demo;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.sazedexpress.api.Student;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	
    	// load hibernate configuration file
    	
    	Configuration configuration=new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	configuration.addAnnotatedClass(Student.class);
    	SessionFactory sessionFactory=configuration.buildSessionFactory();
    	
    	
    	/*
    	Student student =new Student();
    	student.setStudent_name("ghhgg");
    	student.setStudent_country("Indonasia");
    	Student student2 =new Student();
    	student2.setStudent_name("jkkll");
    	student2.setStudent_country("Koria");
    	*/
    	
    	
    	
    	
    	Session session = sessionFactory.openSession();
    	
    	//session.beginTransaction();
    	
    	
    	// to save data
    	/*
    	session.save(student);
    	session.save(student2);
    	*/
    	
    	
    	
    	// get data by id
    	//Student student	=session.get(Student.class, 4);
    
    	
    	
    	// for updating data 
    	/*
	    	Student student=session.get(Student.class,5);
	    	student.setStudent_name("Rabby");
	    	student.setStudent_country("China");
	    	
	    	session.update(student);   
	    	//session.saveOrUpdate(student);
	    	//session.save(student);
	    	// session.beginTransaction().commit()  also create update query and execute autometically
    	*/
    	
    	
    	
    	// get all data from database
    	/*
	    	org.hibernate.query.Query<Student> query=session.createQuery("from Student",Student.class);  // "from Student", here Student is Entity class not table name
	    	List<Student> studentList=query.getResultList();
	    	for (Student tempstudent:studentList) {
				System.out.println(tempstudent);
			}
		*/
    	
    	// deleting data
    	Student student=session.get(Student.class,18);
	    session.delete(student);
    	
	    
	    /*
    	session.beginTransaction().commit();
    	org.hibernate.query.Query<Student> query=session.createQuery("from Student",Student.class);  // "from Student", here Student is Entity class not table name
    	List<Student> studentList=query.getResultList();
    	for (Student tempstudent:studentList) {
			System.out.println(tempstudent);
		}
    	*/
    	
    	
    	session.close();
    	
    	
    	//System.out.println(student);
    	
    }
}
