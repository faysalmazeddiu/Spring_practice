package com.mazedexpress.pm.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.mazedexpress"})
public class ProductAppConfig {
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(getDataSource());
		return jdbcTemplate;
		
	}
	
	@Bean
	public DataSource getDataSource() {
		String url="jdbc:mysql://localhost:3306/ProductManagement?useSSL-false";
		String username="root";
		String password="12345678";
		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl(url);
		driverManagerDataSource.setUsername(username);
		driverManagerDataSource.setPassword(password);
		
		return driverManagerDataSource;
		
	}
	

}
