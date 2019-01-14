package com.au.advjava;

import java.util.*;

public class Company {
	private int companyId;
	private String companyName,city;
	
	Scanner sc=new Scanner(System.in);
	
	TreeSet<Employee> elist = new TreeSet<>();
	
	Company(int companyId,String companyName,String city)
	{
		this.companyId=companyId;
		this.companyName=companyName;
		this.city=city;
		
		System.out.println("Employee Count:");
		int cnt=sc.nextInt();
		for(int i=0;i<cnt;i++)
		{
			System.out.println("Employee "+ (i+1) +" details (id,name,age):");
			int id=sc.nextInt();String name=sc.next();int age=sc.nextInt();
			elist.add(new Employee(id,name,age));
		}
	}
	
	public int getCompanyId() { return this.companyId;}
	public String getName() { return this.companyName;}
	public String getCity() { return this.city;}
	
	public void showEmployeesBelow30() 
	{
		for(Employee e : this.elist)
		{
			if(e.getAge()<30)
				System.out.println("ID:"+e.getId()+" Name:"+e.getName()+" Age"+e.getAge());
		}
	}
	
	public void showEmployeesByAge()
	{
		for(Employee e : this.elist)
			System.out.println("ID:"+e.getId()+" Name:"+e.getName()+" Age"+e.getAge());
	}
}
