package week1;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class Employee {
	private String name;
	private int salary;

	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();
		for (int i = 10; i > 0; i--) {
			list.add(new Employee("Employee" + i, i + 1 * 100000));
		}
		// Task 1 : Iterate list using for loop
		System.out.println("Iterate list using for loop:");
		for (Employee emp : list) {
			System.out.print(emp.getName() + "   ");
		}
		System.out.println();
		// Task 2: Sort employees using their name
		System.out.println("Sort employees using their name");
		List<Employee> employeesSortedList = list.stream().sorted((o1, o2) -> (o1.getName().compareTo(o2.getName())))
				.toList();
		for (Employee emp : employeesSortedList) {
			System.out.print(emp.getName() + "   ");
		}
		System.out.println();
		// Task 3: Iterate employee using Iterator and List Iterator in both directions
		System.out.println("Iterate employee using Iterator and List Iterator in both directions");
		ListIterator<Employee> listIterator = list.listIterator();

		// Forward

		while (listIterator.hasNext()) {
			System.out.print(listIterator.next().getName() + "   ");
		}
		System.out.println();
		// Backward
		while (listIterator.hasPrevious()) {
			System.out.print(listIterator.previous().getName() + "   ");
		}
		System.out.println();
		// Task 4: Use Stream map method to show all the employee name in uppercase
		System.out.println("Use Stream map method to show all the employee name in uppercase");
		List<Employee> newEmployees = list.stream().map(e -> {
			e.setName(e.getName().toUpperCase());
			return e;
		}).collect(Collectors.toList());
		for (Employee emp : newEmployees) {
			System.out.print(emp.getName() + "   ");
		}
		System.out.println();

		// Use stream to calculate average salary.
		System.out.println(list.stream().mapToInt(Employee::getSalary).average().getAsDouble());
		
	}
}
