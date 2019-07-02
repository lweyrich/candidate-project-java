package com.zoomcare.candidatechallenge.test;

import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.zoomcare.candidatechallenge.entity.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest
{
	@Autowired
    private TestRestTemplate restTemplate;
	
	 @LocalServerPort
	 private int port;
	
	@Test
	public void restCallForTopEmployees() {
//		List <LinkedHashMap> employees = (List <LinkedHashMap>)restTemplate.getForObject("http://localhost:"+port+"/employees/top", List.class);
//		for(LinkedHashMap map : employees) {
//			assertTrue(map.containsKey("id"));
//			Set set = map.entrySet();
//			for(Object obj : set) {
//				System.out.println(obj);
//			}
//		}
	}
	
	@Test
	public void restCallFindEmployeeById() {		
		ResponseEntity <Employee> employeeResponse = restTemplate.getForEntity("http://localhost:"+port+"/employee/1", Employee.class);
		assertTrue(employeeResponse.getStatusCode().is2xxSuccessful());
	}
	
}
