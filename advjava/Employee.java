package com.au.advjava;

public class Employee implements Comparable<Employee> {
	private int id, age;
	private String name;
	
	Employee(int id, String name, int age)
	{
		this.id=id;
		this.age=age;
		this.name=name;
	}
	
	public int getId() {return this.id;}
	public int getAge() {return this.age;}
	public String getName() {return this.name;}
	
	@Override
	public int compareTo(Employee e)
	{
		return this.getAge() - e.getAge();
	}
}
