package com.sazedexpress.blc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sazedexpress.blc.converter.CreditCardCoverter;
import com.sazedexpress.blc.converter.CreditCardObjectToStringConverter;
import com.sazedexpress.blc.formatters.BillFormatter;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.sazedexpress.blc")
public class BillProcessAppConfig implements WebMvcConfigurer{
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	
	
	
	
	 
	
	
	 //===>Formatter can be also register by InitBinder Method from Controller. formatter and editor both are working same way.
	// ===> converter also need to register form addFormatter() method
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		System.out.println("fomate registry");
		//registry.addFormatter(new BillFormatter());
		registry.addConverter(new CreditCardCoverter());
		registry.addConverter(new CreditCardObjectToStringConverter());
	}
	
	
	
    
	
}
