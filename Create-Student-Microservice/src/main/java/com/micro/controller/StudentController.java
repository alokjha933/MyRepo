package com.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.request.CreateStudentRequest;
import com.micro.response.StudentResponse;
import com.micro.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/create")
	public StudentResponse createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
		return studentService.createStudent(createStudentRequest);
	}

	@GetMapping(/* value = */"getById/{id}"/* , produces =MediaType.APPLICATION_XML_VALUE */)
	public StudentResponse getById(@PathVariable long id) {
		return studentService.getById(id);
	}

}
