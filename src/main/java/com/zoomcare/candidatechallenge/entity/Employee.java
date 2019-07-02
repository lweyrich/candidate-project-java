package com.zoomcare.candidatechallenge.entity;

import java.util.ArrayList;
import java.util.List;


public class Employee
{
	
	private Long id;
	private Long supervisorId;
	private List <Properties> properties;
	private List <Employee> directReports;

	
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getSupervisorId()
	{
		return supervisorId;
	}

	public void setSupervisorId(Long supervisorId)
	{
		this.supervisorId = supervisorId;
	}
	
	public boolean addProperty(Properties prop) {
		if(properties == null) {
			properties = new ArrayList <Properties>();
		}
		
		return properties.add(prop);
	}

	public List<Properties> getProperties()
	{
		return properties;
	}

	public void setProperties(List<Properties> properties)
	{
		this.properties = properties;
	}

	public List<Employee> getDirectReports()
	{
		return directReports;
	}

	public void setDirectReports(List<Employee> directReports)
	{
		this.directReports = directReports;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Employee#"+id+":Supervisor#"+supervisorId+"\n");
		for(Properties property : this.properties) {
			builder.append("\t"+property+"\n");
		}
		return builder.toString();
	}

}
