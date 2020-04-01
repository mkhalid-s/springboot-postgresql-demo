package com.app.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfiguration {

	@Value("${spring.datasource.url}")
	private String dbUrl;

}
