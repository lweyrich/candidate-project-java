package com.zoomcare.candidatechallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zoomcare.candidatechallenge.entity.Employee;
import com.zoomcare.candidatechallenge.service.EmployeeService;

@RestController
public class EmployeeRestController
{
	@Autowired
	EmployeeService empService;
	
	@RequestMapping(path = "/employee/{id}", method = RequestMethod.GET, produces = "application/json")
    public String employee(@PathVariable Long id) {
		Employee employee =  empService.getEmployeeById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String returnValue = "";
		try
		{
			returnValue = objectMapper.writeValueAsString(employee);
		} catch (JsonProcessingException e)
		{
			returnValue = "{Error:"+e.getLocalizedMessage()+"}";
		}
		return returnValue;
	}
	
	@RequestMapping(path = "/employees/top", method = RequestMethod.GET, produces = "application/json")
    public String topEmployee() {
		List <Employee> employeeList =  empService.findTopLevelEmployees();
		ObjectMapper objectMapper = new ObjectMapper();
		String returnValue = "";
		try
		{
			returnValue = objectMapper.writeValueAsString(employeeList);
		} catch (JsonProcessingException e)
		{
			returnValue = "{Error:"+e.getLocalizedMessage()+"}";
		}
		return returnValue;
	}
}
