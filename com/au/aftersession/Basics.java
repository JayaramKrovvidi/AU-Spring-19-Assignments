package com.au.aftersession;


public class Basics {
	public static void main(String[] args) {
		Employee e1= new Employee(1, "Employee 1", 21, 10000, 1117678876);
		System.out.println("Employee Count: "+e1.cnt);
		
		try
		{
			Employee e2= new Employee(10, "Employee 10", 21, 10000, 678876);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.toString());
		}
		
		Manager m1=new Manager(3,2,"Employee 2",23,23000,1134455634);
		System.out.println("Employee Count: "+m1.cnt);
		m1.addExperience();
		System.out.println("Manager Experience: "+m1.getExperience());
		
		Developer d1=new Developer("JAVA",6,"Employee 3",32,34000,1111273242);
		System.out.println("Employee Count: "+d1.cnt);
		d1.newSkill("C++");
		System.out.println("Skill Sets are: "+ d1.getSkills());
	}
}
