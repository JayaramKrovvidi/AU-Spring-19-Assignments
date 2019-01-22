package spring.au.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import spring.au.model.Employee;

@Repository
public class EmployeeDao{

	private Map<Integer, Employee> repository;
	
	public EmployeeDao() {
		this.repository = new HashMap<>();
		//creating initial data
		Employee emp = new Employee(1, "Pankaj");
		this.repository.put(1, emp);
	}
	
	
	public void store(Employee emp) {
		repository.put(emp.getId(), emp);		
	}

	
	public Employee retrieve(int id) {
		return repository.get(id);
	}

	
	public Employee search(String name) {
		Collection<Employee> emps = repository.values();
		for (Employee emp : emps) {
			if (emp.getName().equalsIgnoreCase(name))
				return emp;
		}
		return null;
	}

	
	public Employee delete(int id) {
		Employee e = repository.get(id);
		this.repository.remove(id);
		return e;
	}
	
	public List<Employee> getAll() {
		List<Employee> emps = new ArrayList<>();
		
		for(Employee e : this.repository.values())
			emps.add(e);
		
		return emps;
	}

}
