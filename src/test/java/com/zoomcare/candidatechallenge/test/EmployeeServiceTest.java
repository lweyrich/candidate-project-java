package com.zoomcare.candidatechallenge.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zoomcare.candidatechallenge.entity.Employee;
import com.zoomcare.candidatechallenge.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest
{

	@Autowired
	private EmployeeService empService;
	
	@Test
	public void findEmployeeById() {
		Long id = 1l;
		
		Employee employee = empService.getEmployeeById(id);
		assertTrue(employee.getId() == 1);
		assertTrue(employee.getSupervisorId() == 0);
		assertTrue(employee.getDirectReports().size() == 3);
		assertTrue(employee.getProperties().size() == 1);
	}
	
	
	@Test
	public void findTopLevelEmployees() {
		List <Employee> topList = empService.findTopLevelEmployees();
		
		assertTrue(topList.size() == 1);
		assertTrue(topList.get(0).getId() == 1l);
	}
}
