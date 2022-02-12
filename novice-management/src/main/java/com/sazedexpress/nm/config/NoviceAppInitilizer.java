package com.sazedexpress.nm.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class NoviceAppInitilizer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		Class[] configClasses= {NoviceAppCofig.class};
		return configClasses;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		String[] mappingStrings= {"/"};
		return mappingStrings;
	}

}
