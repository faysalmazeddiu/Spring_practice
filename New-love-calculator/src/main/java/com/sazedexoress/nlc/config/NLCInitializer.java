package com.sazedexoress.nlc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class NLCInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		Class arr[]= {NewLoveCalculatorAppConfig.class};
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		//String arr[]= {"/mywebsite.com/*"};
		String arr[]= {"/"};

		return arr;
	}

}
