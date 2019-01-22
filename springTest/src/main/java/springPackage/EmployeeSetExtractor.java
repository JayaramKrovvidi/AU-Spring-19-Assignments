package springPackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class EmployeeSetExtractor implements ResultSetExtractor<List<Employee>> {

	@Override
	public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException 
	{
		List<Employee> list = new ArrayList<Employee>();  
        while(rs.next()){  
           Employee employee = new Employee();
           employee.setEmpId(rs.getInt("emp_id"));
           employee.setName(rs.getString("emp_name"));
           employee.setAge(rs.getInt("emp_age"));
           list.add(employee);  
        }  
        return list;
	}

}
