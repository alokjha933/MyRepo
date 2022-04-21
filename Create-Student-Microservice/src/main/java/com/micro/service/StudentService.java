package com.micro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.micro.entity.Student;
import com.micro.feignclient.AddressFeignClient;
import com.micro.repository.StudentRepository;
import com.micro.request.CreateStudentRequest;
import com.micro.response.AddressResponse;
import com.micro.response.StudentResponse;

import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	WebClient webClient;

	@Autowired
	AddressFeignClient addressFeignClient;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());

		student.setAddressId(createStudentRequest.getAddressId());
		student = studentRepository.save(student);
		StudentResponse sr = new StudentResponse(student);
		// sr.setAddressResponse(this.getAddressById(student.getAddressId()));
		sr.setAddressResponse(addressFeignClient.getById(student.getAddressId()));

		return sr;
	}

	public StudentResponse getById(long id) {
		Student std = studentRepository.findById(id).get();
		StudentResponse sr = new StudentResponse(std);
		// sr.setAddressResponse(this.getAddressById(std.getAddressId()));
		sr.setAddressResponse(addressFeignClient.getById(std.getAddressId()));
		return sr;
	}

	public AddressResponse getAddressById(long id) {
		Mono<AddressResponse> data = webClient.get().uri("/get-address/" + id).retrieve()
				.bodyToMono(AddressResponse.class);
		return data.block();
	}
}
