package springPackage;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springPackage/applicationContext.xml");
		
		EmployeeDAO edao = (EmployeeDAO)ctx.getBean("edao");
		int status = edao.saveEmployee(new Employee("Jayaram",21));
		System.out.println(status);
		
		List<Employee> employeesByMapper = edao.getAllEmployeesByMapper();
		System.out.println("Employees with Row Mapper:");
		for(Employee e : employeesByMapper)
		{
			System.out.println("ID: "+e.getEmpId()+" Name: "+e.getName()+" Age: "+e.getAge());
		}
		
		List<Employee> employeesBySetExtractor = edao.getEmployeesBySetExtractor();
		System.out.println("Employees with Result Set Extractor:");
		for(Employee e : employeesBySetExtractor)
		{
			System.out.println("ID: "+e.getEmpId()+" Name: "+e.getName()+" Age: "+e.getAge());
		}
		
		System.out.println("Using Factory method");
		Employee employee = (Employee) ctx.getBean("emp");
		employee.printMessage();
	}
}
