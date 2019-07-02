package com.zoomcare.candidatechallenge.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zoomcare.candidatechallenge.entity.Employee;

@Transactional
@Repository
public class EmployeeRepository implements RowMapper<Employee> 
{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Employee emp = new Employee();
		emp.setId(rs.getLong("id"));
		emp.setSupervisorId(rs.getLong("supervisor_id"));
		return emp;
	}

	public List<Employee> loadAllTopLevel() {
		return (List<Employee>) jdbcTemplate.query("SELECT * FROM employee WHERE supervisor_id IS NULL", this);
	}
	  
	public Employee findEmployee(Long id) {
		return (Employee) jdbcTemplate.query("SELECT * FROM employee WHERE id = ?",new Object[] {id}, this).get(0);
	}
	
	public List <Employee> listOfDirectReportsBySupervisorId(Long id){
		return (List<Employee>) jdbcTemplate.query("SELECT * FROM employee WHERE supervisor_id = ?",new Object[] {id} , this);
	}
}
