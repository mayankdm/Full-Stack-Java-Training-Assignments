package training.week2;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String Department;
	private long Salary;
	private String password;

	public Employee() {
		super();
	}

	public Employee(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	public Employee(int id, String firstName, String lastName, String department, long salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		Department = department;
		Salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public long getSalary() {
		return Salary;
	}

	public void setSalary(long salary) {
		Salary = salary;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
