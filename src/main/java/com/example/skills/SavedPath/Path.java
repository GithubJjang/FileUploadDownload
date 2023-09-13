package com.example.skills.SavedPath;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Path {

	@Bean
	public String fileDir() {
		return "C:/test/";
	}
}
