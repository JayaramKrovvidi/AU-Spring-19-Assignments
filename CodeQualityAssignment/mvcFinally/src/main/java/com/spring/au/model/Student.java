package com.spring.au.model;


public class Student {
	private int studentId;
	private String studentName;
	
	public static final String STUDENT_NAME = "name";
	
	public Student() {}
	
	public Student(int id, String name)
	{
		this.studentId=id;
		this.studentName=name;
	}

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
