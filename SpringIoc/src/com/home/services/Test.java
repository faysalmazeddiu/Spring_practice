package com.home.services;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("serviceBeans.xml");
		System.out.println("Xml loded");
		Clients clients=context.getBean("clients",Clients.class);
		clients.invokeServices();
		context.close();

	}

}
