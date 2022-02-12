package com.sazedexpress.nm.config;

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
@ComponentScan(basePackages = {"com.sazedexpress"})
public class NoviceAppCofig {
	@Bean
	InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	
	@Bean
	JdbcTemplate jdbcTemplate() {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource());
		return jdbcTemplate;
		
	}
	
	@Bean
	public DataSource dataSource() {
		
		String urlString="jdbc:mysql://localhost:3306/mazedexpress?useSSL-false";
		String usernameString="root";
		String passwordString="12345678";
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername(usernameString);
		dataSource.setPassword(passwordString);
		dataSource.setUrl(urlString);
		
		return dataSource;
		
		
	}

}
