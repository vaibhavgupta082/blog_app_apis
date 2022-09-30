package com.vaibhavgupta.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogAppApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApiApplication.class, args);
	}
//for git:  Documents/workspace-spring-tool-suite-4-4.16.0.RELEASE/blog-app-api/
	//Java bean is validated with JSR 380 known as Bean Validation 2.0
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
		
	}

}
