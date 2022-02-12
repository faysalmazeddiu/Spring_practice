package com.sazedexoress.nlc.config;

import java.util.Properties;
import java.util.logging.Logger;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sazedexoress.nlc.api.Amount;
import com.sazedexoress.nlc.formatter.AmountFormatter;
import com.sazedexoress.nlc.formatter.CreditCardFormatter;
import com.sazedexoress.nlc.formatter.PhoneNumberFormatter;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.sazedexoress.nlc")
@PropertySource("classpath:email.properties")

/*
  	to load multiple properties file: user should use @PropertySources() annotation which take an array of @PropertySource() annotation
  	Ex-
  			@PropertySources(
  					{ @PropertySource("classpath:email.properties"),
  					  @PropertySource("classpath:email.properties") }
  			)
  	
 */

public class NewLoveCalculatorAppConfig implements WebMvcConfigurer{
	
	@Autowired
	private Environment env;
	
	// to print any message by logger
	Logger logger=Logger.getLogger(NewLoveCalculatorAppConfig.class.getName());
	
	@Bean
	InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	
	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean localValidatorFactoryBean=new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		return localValidatorFactoryBean;
	}
	
	
	// configuration for sending mail
	
	@Bean
	public JavaMailSender configureJavaMailSender() {
		
		JavaMailSenderImpl javaMailSenderImpl=new JavaMailSenderImpl();
		
		//System.out.println(env.getProperty("mail.host"));
		logger.info(">>>>>>>>>>>"+env.getProperty("mail.host")); // for printing something in console
		
		javaMailSenderImpl.setHost(env.getProperty("mail.host"));
		javaMailSenderImpl.setUsername(env.getProperty("mail.username"));
		javaMailSenderImpl.setPassword(env.getProperty("mail.password"));
		javaMailSenderImpl.setPort(getIntProperty("mail.port"));
		
		javaMailSenderImpl.setJavaMailProperties(getMailProperties());
		return javaMailSenderImpl;
		
	}
	
	Properties getMailProperties(){
		Properties mailProperties=new Properties();
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		return mailProperties;
		
	}
	
	int getIntProperty(String key) {
		String property=env.getProperty(key);
		return Integer.parseInt(property);
	}
	
	
	// over ride method from WebMvcConfigurer interface which is used for Formatter
	@Override
	public void addFormatters(FormatterRegistry registry) {
		System.out.println("fomate registry");
		registry.addFormatter(new PhoneNumberFormatter());
		registry.addFormatter(new CreditCardFormatter());
		registry.addFormatter(new AmountFormatter());
	}
	
	//over ride method from WebMvcConfigurer interface which is used for Formatter
	@Override
	public org.springframework.validation.Validator getValidator() {
		return validator();
	}

}
