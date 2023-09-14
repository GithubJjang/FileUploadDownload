package com.example.skills.savedpath;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class path {

	@Bean
	public String fileDir() {
		return "C:/잡동사니/FileUploadDownload/src/main/resources/static/img/";
	}
}
