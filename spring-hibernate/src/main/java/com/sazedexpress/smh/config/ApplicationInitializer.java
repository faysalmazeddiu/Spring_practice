package com.sazedexpress.smh.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] configClasses= {ApplicationConfig.class};
		return configClasses;
	}

	@Override
	protected String[] getServletMappings() {
		String[] mappingString= {"/"};
		return mappingString;
	}

}
