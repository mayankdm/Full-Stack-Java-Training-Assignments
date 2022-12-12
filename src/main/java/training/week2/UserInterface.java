package training.week2;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
	public static void main(String[] args) {
		System.out.println("Welcome to the portal!");
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter username:");
		String id = sc.nextLine();
		System.out.println("please enter password:");
		String password = sc.nextLine();
		boolean isUser = EmployeeDao.authenticate(id, password);
		if (isUser) {
			List<Employee> empl = EmployeeDao.getEmployee(id);
			if (empl.get(0) != null && empl.get(0).getFirstName().equalsIgnoreCase("admin")) {
				while (true) {
					System.out.println("Welcome " + empl.get(0).getFirstName() + "!");
					System.out.println("1.Add a new Employee.");
					System.out.println("2.See all Employee.");
					System.out.println("3.Search an Employee.");
					System.out.println("4.Delete an Employee.");
					System.out.println("5.Update an Employee.");
					System.out.println("6. Exit.");
					System.out.println("Select a number between 1 to 6");
					int num = sc.nextInt();
					if (num == 1) {
						Employee _emp = new Employee();
						System.out.println("Add Employee Form:");
						System.out.println("Enter id:");
						sc.nextLine();
						_emp.setId(sc.nextInt());
						sc.nextLine();
						System.out.println("Enter First Name:");
						_emp.setFirstName(sc.nextLine());
						System.out.println("Enter :Last Name:");
						_emp.setLastName(sc.nextLine());
						System.out.println("Enter Department:");
						_emp.setDepartment(sc.nextLine());
						System.out.println("Enter Salary in number:");
						_emp.setSalary(sc.nextLong());
						sc.nextLine();
						System.out.println("Enter Password:");
						_emp.setPassword(sc.nextLine());
						System.out.println(EmployeeDao.save(_emp));
					} else if (num == 2) {
						System.out.println("List of Employees:");
						List<Employee> list = EmployeeDao.getAllEmployee();
						list.stream().map(employee -> employee.getFirstName()).forEach(System.out::println);
					} else if (num == 3) {
						while(true) {
							System.out.println("Search Employee form:");
							System.out.println("1.Search Employee(s) by id.");
							System.out.println("2.Search Employee(s) by First Name");
							System.out.println("3.Search Employee(s)by Last Name");
							System.out.println("4.Search Employee(s) by Department");
							System.out.println("5.Search Employee(s) by Salary");
							System.out.println("6. Exit.");
							int num2 = sc.nextInt();
							sc.nextLine();
							if(num2 == 1) {
								System.out.println();
								int eid = sc.nextInt();
								EmployeeDao.getEmployee(sc.nextLine());
							}
							if(num2 == 2) {
								
							}
							if(num2 == 3) {
								
							}
							if(num2 == 4) {
								
							}
							if(num2 == 5) {
								
							}
							if(num2 == 6) {
								break;
							}
							else {
								System.out.println("Wrong Entry!");
							}
						}
					} else if (num == 4) {
						System.out.println("Enter id to delete Employee:");
						String msg = EmployeeDao.delete(sc.nextLine());
						System.out.println(msg);
					} else if (num == 5) {
						Employee _emp = new Employee();
						System.out.println("Update Employee Form:");
						System.out.println("Enter First Name:");
						_emp.setFirstName(sc.nextLine());
						System.out.println("Enter :Last Name:");
						_emp.setLastName(sc.nextLine());
						System.out.println("Enter Department:");
						_emp.setDepartment(sc.nextLine());
						System.out.println("Enter Salary in number:");
						_emp.setSalary(sc.nextLong());
						EmployeeDao.update(_emp);
					} else if (num == 6) {
						break;
					} else {
						System.out.println("Wrong Entry!");
					}
				}
			} else if (empl.get(0) != null) {
				System.out.println("Welcome " + empl.get(0).getFirstName() + "!");
				System.out.println("1.See all Employee.");
				System.out.println("2.See Profile.");
				System.out.println("3.Search an Employee.");
				System.out.println("Select a number between 1 to 3");
				int num = sc.nextInt();
				if (num == 1) {
					System.out.println("List of Employees:");
					List<Employee> list = EmployeeDao.getAllEmployee();
					System.out.println(list);
				}
			} else {
				System.out.println("User not available!");
			}
		} else {
			System.out.println("User not available, please try again!");
		}

	}
}
