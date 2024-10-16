package com.springboot.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.application.controller.ApplicationController;
import com.springboot.application.model.Student;
import com.springboot.application.repository.StudentRepository;
import com.springboot.application.service.ApplicationService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringBootApplicationCrudApplicationTests {

	@Autowired
	ApplicationService applicationService;

	@Autowired
	ApplicationController applicationController;

	@Autowired
	StudentRepository studentDao;

	@Test
	@DisplayName("Subscription message service test ")
	void testSubscriptionMessage() {
		String user = "Peter";
		String message = applicationService.getSubscriptionMessage(user);
		assertEquals("Hello " + user + ", Thanks for the subscription!", message);
	}

	@Test
	public void testCreate() {
		Student p = new Student();
		p.setId(1L);
		p.setsName("iPhone XR");

		applicationService.addStudentDtls(p);
		assertNotNull(studentDao.findById(1L).get());
	}

	@Test
	public void testReadAll() {
		java.util.List<Student> list = studentDao.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
}
