package com.au.advjava;

import java.util.*;

public class RunnerMain {
	
	static Scanner sc;
	
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		
		ArrayList<Company> clist = new ArrayList<>();
		
		System.out.println("Number of companies:");
		int cnum=sc.nextInt();
		for(int i=0;i<cnum;i++)
		{
			clist.add(newCompany());
		}
		
		//Sorting companies by id
		clist.sort(new Comparator<Company>() {
			@Override
			public int compare(Company c1, Company c2)
			{
				return c1.getCompanyId()-c2.getCompanyId();
			}
		});
		
		//Companies with particular city
		String city= sc.next();
		System.out.println();
		for(Company c : clist)
		{
			if(c.getCity().equalsIgnoreCase(city))
				System.out.println("ID"+c.getCompanyId()+" Name"+c.getName()+" City"+c.getCity());
		}
		
		System.out.println("Company ID to list emloyees:");
		int companyId=sc.nextInt();
		
		for(Company c : clist)
		{
			if(c.getCompanyId()==companyId) 
			{
				//List All Employees of a company whose age is <30
				System.out.println("Employees Below 30:");
				c.showEmployeesBelow30();
				
				//List All Employees of a company with increasing order of age
				System.out.println("Employees By Age");
				c.showEmployeesByAge();
			}
		}
	}
	
	protected static Company newCompany()
	{
		System.out.println("(id,name,city):");
		int companyId=sc.nextInt();
		String companyName=sc.next();
		String city=sc.next();
		return new Company(companyId,companyName,city);
	}
}
