package com.micro.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan({ "com.micro.controller", "com.micro.service" })
@EntityScan("com.micro.entity")
@EnableJpaRepositories("com.micro.repository")
@EnableFeignClients("com.micro.feignclient")
public class CreateStudentMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateStudentMicroserviceApplication.class, args);
	}

	@Value("${address.service.url}")
	private String baseUrlForRestCall;

	@Bean
	public WebClient webClient() {
		WebClient webClient = WebClient.builder().baseUrl(baseUrlForRestCall).build();
		return webClient;
	}
}
