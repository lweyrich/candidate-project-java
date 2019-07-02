package com.zoomcare.candidatechallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoomcare.candidatechallenge.entity.Employee;
import com.zoomcare.candidatechallenge.entity.Properties;
import com.zoomcare.candidatechallenge.repository.EmployeeRepository;
import com.zoomcare.candidatechallenge.repository.PropertiesRepository;

@Service
public class EmployeeService
{
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private PropertiesRepository propRepo;
	
	public Employee getEmployeeById(Long id) {
		Employee employee = empRepo.findEmployee(id);
		List <Employee> directReports = empRepo.listOfDirectReportsBySupervisorId(id);
		for(Employee subEmployee : directReports) {
			subEmployee = loadEmployeeData(subEmployee);
		}
		employee.setDirectReports(directReports);
		List <Properties> properties = propRepo.findPropertiesForEmployee(id);
		employee.setProperties(properties);
		
		return employee;
	}
	
	public List <Employee> findTopLevelEmployees(){
		List <Employee> list = empRepo.loadAllTopLevel();
		for(Employee employee: list) {
			List <Employee> directReports = empRepo.listOfDirectReportsBySupervisorId(employee.getId());
			for(Employee subEmployee : directReports) {
				subEmployee = loadEmployeeData(subEmployee);
			}
			employee.setDirectReports(directReports);
			List <Properties> properties = propRepo.findPropertiesForEmployee(employee.getId());
			employee.setProperties(properties);
		}
		return list;
	}
	
	private Employee loadEmployeeData(Employee employee) {
		List <Properties> properties = propRepo.findPropertiesForEmployee(employee.getId());
		employee.setProperties(properties);
		
		List <Employee> directReports = empRepo.listOfDirectReportsBySupervisorId(employee.getId());
		for(Employee subEmployee :directReports) {
			subEmployee = loadEmployeeData(subEmployee);
		}
		employee.setDirectReports(directReports);
		return employee;
	}
}
