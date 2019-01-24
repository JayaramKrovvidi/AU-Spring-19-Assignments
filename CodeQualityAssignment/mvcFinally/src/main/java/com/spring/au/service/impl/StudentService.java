package com.spring.au.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.au.dao.impl.StudentDao;
import com.spring.au.model.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	public String getName()
	{
		return studentDao.getNameFromBase();
	}
	
	public String insertStud(Student student)
	{
		return studentDao.insertHim(student);
	}
}
