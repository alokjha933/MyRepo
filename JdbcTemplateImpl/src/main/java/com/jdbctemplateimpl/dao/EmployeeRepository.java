package com.jdbctemplateimpl.dao;

import java.util.List;

import com.jdbctemplateimpl.model.Employees;

public interface EmployeeRepository {

	Employees save(Employees emp);

	Employees update(Employees emp);

	String delete(long id);

	Employees fetchById(long id);

	List<Employees> fetchListOfEmployee();

}
