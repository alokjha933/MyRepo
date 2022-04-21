package com.jdbctemplateimpl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdbctemplateimpl.dao.EmployeeRepositoryImpl;
import com.jdbctemplateimpl.model.Employees;

//@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	EmployeeRepositoryImpl employeeRepository;

	// get All Employee details
	@GetMapping(value = "/employees")
	public List<Employees> getAllEmployees() {
		return employeeRepository.fetchListOfEmployee();
	}

	// create Employee
	@PostMapping(value = "/employees")
	public Employees addEmployees(@RequestBody Employees employee) {
		return employeeRepository.save(employee);
	}

	// get Employee Details by Id

	@GetMapping(value = "/employees/{id}")
	public ResponseEntity<Employees> getEmployeeDtlsById(@PathVariable Long id) {
		Employees employee = employeeRepository.fetchById(id);
		return ResponseEntity.ok(employee);
	}

	// Update Employee Details
	@PutMapping(value = "/employees/{id}")
	public ResponseEntity<Employees> updateEmployeeDetails(@PathVariable Long id,
			@RequestBody Employees employeeDetails) {
		Employees employee = employeeRepository.fetchById(id);
		employee.setFirst_name(employeeDetails.getFirst_name());
		employee.setLast_name(employeeDetails.getLast_name());
		employee.setEmail_id(employeeDetails.getEmail_id());
		employee.setImg_url(employeeDetails.getImg_url());
		Employees updateEmployee = employeeRepository.save(employee);

		return ResponseEntity.ok(updateEmployee);
	}

	// delete Employee
	@DeleteMapping(value = "/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
		Employees employee = employeeRepository.fetchById(id);
		employeeRepository.delete(id);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	/*
	 * @GetMapping(value="/employees/{id}") public String getImgUrl(@PathVariable
	 * Long id) { return employeeRepository.findById(id).get().getImage(); }
	 */

}
