package com.spring.au.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.au.model.Student;

@Repository
public class StudentDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String getNameFromBase()
	{
		return jdbcTemplate.queryForObject("select student_name from student where student_id = 1", String.class);
	}
	
	public String insertHim(Student student)
	{
		String insertQuery = "insert into student values("+student.getStudentId()+",'"+student.getStudentName()+"')";
		
		int affected = jdbcTemplate.update(insertQuery);
		
		return affected==1 ? "Updated" : "Not Updated";
	}

}
