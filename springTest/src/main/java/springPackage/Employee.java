package springPackage;

public class Employee 
{
	private int empId, age;
	private String name;
	
	static final Employee innerEmployee = new Employee();
	
	//factory Method
	public static Employee getEmployee()
	{
		System.out.println("Inside Factory Method");
		return innerEmployee;
	}
	
	
	public Employee() {}
	
	public Employee(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void printMessage()
	{
		System.out.println("This is an Employee");
	}
}
