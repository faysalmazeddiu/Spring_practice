package com.sazedexpres.sp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SessionAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class arr[]= {SessionAppConfig.class};
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		String arr[]= {"/"};

		return arr;
	}

}
