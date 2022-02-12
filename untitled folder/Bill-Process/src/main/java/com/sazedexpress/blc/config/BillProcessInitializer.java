package com.sazedexpress.blc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class BillProcessInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] classes= {BillProcessAppConfig.class};
		return classes;
	}

	@Override
	protected String[] getServletMappings() {
		String[] urlMapping= {"/"};
		return urlMapping;
	}

}
