package com.springboot.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springboot.aspect.AopConfig;
import com.springboot.controller.ApplicationController;
import com.springboot.event.AuditEventPublisher;
import com.springboot.exception.ControllerAdviceHandler;
import com.springboot.service.ApplicationService;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = { ApplicationController.class })
@ComponentScan(basePackageClasses = { AopConfig.class })
@ComponentScan(basePackageClasses = { ApplicationService.class })
@ComponentScan(basePackageClasses = { ControllerAdviceHandler.class })
@ComponentScan(basePackageClasses = { AuditEventPublisher.class })
@EntityScan(basePackages = { "com.springboot.model" })
@EnableJpaRepositories("com.springboot.repository")
public class SpringBootApplicationCrudApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationCrudApplication.class, args);
	}

}
