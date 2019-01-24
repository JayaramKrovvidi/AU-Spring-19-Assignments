package filemanager;

import java.time.LocalDate;

public class Student implements Comparable<Student>{
	
	private int studentId;
	private String studentName;
	private LocalDate studentDOB;
	private int mathsMarks, physicsMarks, chemistryMarks;
	private int studentTotal;
	
	public Student() {}
	
	public Student(int studentId, String studentName, LocalDate studentDOB, int mathsMarks, int physicsMarks,
			int chemistryMarks, int studentTotal) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentDOB = studentDOB;
		this.mathsMarks = mathsMarks;
		this.physicsMarks = physicsMarks;
		this.chemistryMarks = chemistryMarks;
		this.studentTotal = studentTotal;
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
	public LocalDate getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(LocalDate studentDOB) {
		this.studentDOB = studentDOB;
	}
	public int getMathsMarks() {
		return mathsMarks;
	}
	public void setMathsMarks(int mathsMarks) {
		this.mathsMarks = mathsMarks;
	}
	public int getPhysicsMarks() {
		return physicsMarks;
	}
	public void setPhysicsMarks(int physicsMarks) {
		this.physicsMarks = physicsMarks;
	}
	public int getChemistryMarks() {
		return chemistryMarks;
	}
	public void setChemistryMarks(int chemistryMarks) {
		this.chemistryMarks = chemistryMarks;
	}
	public int getStudentTotal() {
		return studentTotal;
	}
	public void setStudentTotal(int studentTotal) {
		this.studentTotal = studentTotal;
	}
	@Override
	public int compareTo(Student o) {
		if(this.studentTotal == o.studentTotal)
		{
			return this.studentDOB.compareTo(o.studentDOB);
		}
		else
			return o.studentTotal-this.studentTotal;
	}
	
	
}
