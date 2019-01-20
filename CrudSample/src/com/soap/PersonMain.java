package com.soap;

import java.io.Serializable;
import java.util.LinkedList;


public class PersonMain {
static LinkedList<Person> persons;
	
	public void createPerson(int id, String name)
	{
		persons.add(new Person(id, name));
	}
	
	public Person findPersonById(int id)
	{
		for(Person p: persons)
		{
			if(p.getId()==id)
				return p;
		}
		return null;
	}
	
	public String updatePerson(int id, String name)
	{
		Person p = findPersonById(id);
		if(p != null)
		{
			p.setName(name);
			return "Details Updated Successfully";
		}
		return "Person Not found";
	}
	
	public String deletePerson(int id)
	{
		Person p = findPersonById(id);
		if(p != null)
		{
			persons.remove(p);
			return "Person was removed from the list Successfully";
		}
		return "Person Not found to delete";
	}
	
	public String findPersonByName(String name)
	{
		StringBuilder byName = new StringBuilder("Found: ");
		for(Person p : persons)
		{
			if(p.getName().equals(name))
				byName.append("Id: " + p.getId() + " Name: " + p.getName() + "\n" );
		}
		return byName.toString();
	}
	
	
}

class Person implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Person(int id, String name)
	{
		this.id=id;
		this.name=name;
	}
	public String toString()
	{
		return this.getId()+ this.getName();
	}
}