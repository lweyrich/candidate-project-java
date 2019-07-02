package com.zoomcare.candidatechallenge.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zoomcare.candidatechallenge.entity.Properties;

@Transactional
@Repository
public class PropertiesRepository implements RowMapper<Properties>
{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public Properties mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Properties prop = new Properties();
		prop.setKey(rs.getNString("key"));
		prop.setValue(rs.getNString("value"));
		return prop;
	}
	
	public List <Properties> findPropertiesForEmployee(Long employeeId){
		List <Properties> list = jdbcTemplate.query("SELECT * FROM property WHERE employee_id = ?", new Object[] { employeeId }, this);
		return list;
	}
}
