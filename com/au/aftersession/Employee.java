package com.au.aftersession;


public class Employee {
	static int cnt=0;
	private int id,salary,phone,age;
	private String name="";
	
	public int getId()	    { return this.id;	 }
	public int getPhone()	{ return this.phone; }
	public int getSalary()	{ return this.salary;}
	public int getAge()	    { return this.age;	 }
	public String getName()	{ return this.name;  }
	
	public void setId(int id)
	{ 
		this.id=id; 
	}
	public void setPhone(Integer phone)
	{ 
		if(phone.toString().length() == 10)
			this.phone=phone;
		else
			throw new IllegalArgumentException("Phone number not valid- Should be 10 digits");
	}
	public void setAge(int age)
	{ 
		this.age=age; 
	}
	public void setSalary(int salary)
	{ 
		this.salary=salary;
	}
	public void setName(String name)
	{ 
		this.name=name; 
	}
	
	
	public Employee(int id, String name, int age,int salary, int phone)
	{
		setId(id);
		setPhone(phone);
		setSalary(salary);
		setName(name);
		setAge(age);
		cnt++;
	}
	
	
	public int takeSalary()
	{
		this.salary+=1000;
		return this.salary;
	}
}

class Manager extends Employee
{
	private int experience;
	public int getExperience()
	{
		return this.experience;
	}
	public void setExperience(int experience)
	{
		if(experience>2)
			this.experience=experience;
	}
	Manager(int exp, int id, String name, int age,int salary, int phone)
	{
		super(id,name,age,salary,phone);
		setExperience(exp);
	}
	
	public int addExperience()
	{
		this.experience+=1;
		return this.experience;
	}
}

class Developer extends Employee
{
	private String skillset="";
	
	public String getSkills()
	{
		return this.skillset;
	}
	public void setSkills(String skillset)
	{
		if(skillset=="")
			this.skillset=skillset;
	}
	
	Developer(String sks, int id, String name, int age,int salary, int phone)
	{
		super(id,name,age,salary,phone);
		this.skillset=sks;
	}
	
	public String newSkill(String s)
	{
		this.skillset+=" " +s;
		return this.skillset;
	}
	
}
 