package com.springboot.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.event.AuditEventPublisher;
import com.springboot.model.Student;
import com.springboot.model.Users;
import com.springboot.service.ApplicationService;

@RestController
public class ApplicationController {

	@Autowired
	ApplicationService appService;

	@Autowired
	AuditEventPublisher auditEventPublisher;

	@GetMapping(value = "/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> fetchStudentDtksById(@PathVariable Long id) {
		Student studentDtls = appService.getStudentDetailsById(id);

		return ResponseEntity.ok(studentDtls);
	}

	@GetMapping(value = "/students/{id}")
	public Student fetchStudentDtksByIds(@PathVariable Long id) {
		System.out.println(appService.getStudentDetailsById(id).getEmail_Dtls().stream().collect(Collectors.toList()));
		return appService.getStudentDetailsById(id);
	}

	@PostMapping(value = "/student")
	public Student addStudentDtls(@RequestBody Student student) {
		return appService.addStudentDtls(student);
	}

	@PostMapping(value = "/users")
	public String addUsers(@RequestBody Users user) {
		auditEventPublisher.publishEvent("User Saved Successfully:  " + user.getName());
		return "User data saved successfully";
	}
}
