package com.sazedexoress.nlc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class NewLoveCalculatorInitializer{ //implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		
		AnnotationConfigWebApplicationContext webApplicationContext=new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(NewLoveCalculatorAppConfig.class);
		
		
		DispatcherServlet dispatcherServlet=new DispatcherServlet(webApplicationContext);
		
		ServletRegistration.Dynamic  myServeletRegisterDynamic=servletContext.addServlet("myDispatcherServelete", dispatcherServlet);
		myServeletRegisterDynamic.setLoadOnStartup(1);
		myServeletRegisterDynamic.addMapping("/mywebsite.com/*");

	}

}
