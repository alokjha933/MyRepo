package com.jdbctemplateimpl.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.jdbctemplateimpl.model.Employees;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private static final String INSERT_USER_QUERY = "INSERT INTO Employees(id,firstName,lastName,emailId,image) values(?,?,?,?)";
	private static final String UPDATE_USER_BY_ID_QUERY = "UPDATE Employees SET firstName=? WHERE ID=?";
	private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM Employees WHERE ID=?";
	private static final String DELETE_USER_BY_ID = "DELETE FROM Employees WHERE ID=?";
	private static final String GET_USERS_QUERY = "SELECT * FROM Employees";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Employees save(Employees emp) {
		jdbcTemplate.update(INSERT_USER_QUERY, emp);
		return emp;
	}

	@Override
	public Employees update(Employees emp) {
		jdbcTemplate.update(UPDATE_USER_BY_ID_QUERY, emp);
		return emp;
	}

	@Override
	public String delete(long id) {
		jdbcTemplate.update(DELETE_USER_BY_ID, id);
		return "deleted Id" + id;
	}

	@Override
	public Employees fetchById(long id) {
		return jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, (rs, rownum) -> {
			return new Employees(rs.getLong("id"), rs.getString("firstName"), rs.getString("lastName"),
					rs.getString("emailId"));
		});
	}

	@Override
	public List<Employees> fetchListOfEmployee() {
		return jdbcTemplate.query(GET_USERS_QUERY, (rs, rownum) -> {
			return new Employees(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"),
					rs.getString("email_id"));
		});
	}

}
