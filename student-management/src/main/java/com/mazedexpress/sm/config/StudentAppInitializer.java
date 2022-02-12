package com.mazedexpress.sm.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class StudentAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		Class[] configFile= {StudentAppConfig.class}; 
		return configFile;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		String[] mapping= {"/"};
		return mapping;
	}

}
