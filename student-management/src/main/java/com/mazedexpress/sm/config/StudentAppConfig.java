package com.mazedexpress.sm.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.mazedexpress"})
public class StudentAppConfig implements WebMvcConfigurer{
	
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
		
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplete=new JdbcTemplate(getDataSource());
		return jdbcTemplete;
	}
	
	@Bean
    public DataSource getDataSource() {
		
		String url="jdbc:mysql://localhost:3306/mazedexpress?useSSL-false";
		String username="root";
		String password="12345678";
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	
	
	// for adding css , js , image file
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/URLToReachResourcesFolder/**").addResourceLocations("/resources/");
		
		//registry.addResourceHandler("/URLToReachResourcesFolder/**").addResourceLocations("/resources/images/");
		
		
	}

}
