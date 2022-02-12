package com.mazedexpress.pm.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ProductAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		Class[] confiClass= {ProductAppConfig.class};
		return confiClass;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		String[] mappiStrings= {"/"};
		return mappiStrings;
	}

}
