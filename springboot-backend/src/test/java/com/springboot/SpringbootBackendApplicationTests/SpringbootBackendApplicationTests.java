package com.springboot.SpringbootBackendApplicationTests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.springboot.controller.EmployeeController;
import com.springboot.model.Employee;
import com.springboot.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { com.springboot.demo.SpringbootBackendApplication.class })
class SpringbootBackendApplicationTests {

	@Autowired
	private EmployeeController employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void getEmpDtls() {
		when(employeeRepository.findAll())
				.thenReturn(Stream.of(new Employee("AA", "hh", "aa@gmail.com")).collect(Collectors.toList()));

		assertEquals(1, employeeService.getAllEmployees().size());
	}

	@Test
	public void saveUserTest() {
		Employee user = new Employee("AA", "hh", "aa@gmail.com");
		when(employeeRepository.save(user)).thenReturn(user);
		assertEquals(user, employeeService.addEmployees(user));
	}

	/*
	 * @Test public void deleteUserTest() { Employee user = new Employee("AA", "hh",
	 * "aa@gmail.com"); employeeService.deleteEmployee(1L);
	 * verify(employeeRepository, times(1)).delete(user); }
	 */

}
