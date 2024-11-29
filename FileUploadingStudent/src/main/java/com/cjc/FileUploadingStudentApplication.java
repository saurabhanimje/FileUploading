package com.cjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class FileUploadingStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadingStudentApplication.class, args);
	}

	@Bean
	public ObjectMapper objmapper()
	{
		return new ObjectMapper();
	}
}
