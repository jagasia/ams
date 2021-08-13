package com.cts.attendance;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class UserServiceApplication {

	@Bean
	public JdbcTemplate getJdbcTemplate(DataSource dataSource)
	{
	    JdbcTemplate jdbcTemplate = new JdbcTemplate();
	    jdbcTemplate.setDataSource(dataSource);
	    jdbcTemplate.setQueryTimeout(20); //20 seconds
	    jdbcTemplate.setFetchSize(10);  //fetch 10 rows at a time
	    return jdbcTemplate;

	}
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
