package springPackage;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAO {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int saveEmployee(Employee e)
	{
		String query = "insert into employee(emp_name,emp_age) values(" + "'" + e.getName() + "'," + e.getAge() + ");";
		return jdbcTemplate.update(query);
	}
	
	public List<Employee> getAllEmployeesByMapper()
	{
		String query = "select * from employee";
		List <Employee> employees = jdbcTemplate.query(query, new EmployeeMapper());
		return employees;
	}
	
	public List<Employee> getEmployeesBySetExtractor()
	{
		String query = "select * from employee";
		List <Employee> employees = jdbcTemplate.query(query, new EmployeeSetExtractor());	         
		return employees;
	}

}
