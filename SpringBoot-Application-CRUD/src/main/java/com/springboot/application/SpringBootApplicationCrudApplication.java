package com.springboot.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaClient
public class SpringBootApplicationCrudApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringBootApplicationCrudApplication.class);
		app.run(args);
	}
}
