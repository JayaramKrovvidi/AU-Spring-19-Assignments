package com.spring.au.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.au.model.Student;
import com.spring.au.service.impl.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired	// tells that this class needs a dynamic instantiation of below reference.
	StudentService studentService;
	
	@GetMapping("/getStudentName")
	public String getStudentName()
	{
		return studentService.getName();
	}
	
	@PostMapping("/insertstudent")
	public String insertStudent(@RequestBody Student student)
	{
		return studentService.insertStud(student);
	}

}
