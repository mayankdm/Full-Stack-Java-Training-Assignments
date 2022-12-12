package training.week2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	public static boolean authenticate(String username, String password) {
		Connection con = JdbcPostgresqlConnection.getConnection();
		String query = "SELECT * FROM EMPLOYEE WHERE firstname=? AND password=?";
		boolean isUserAvailable = false;
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			boolean result = statement.execute();
			if (result) {
				isUserAvailable = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUserAvailable;

	}

	public static List<Employee> getAllEmployee() {
		Connection con = JdbcPostgresqlConnection.getConnection();
		String sql = "SELECT * FROM EMPLOYEE";
		Statement statement;
		List<Employee> employees = null;
		try {
			statement = con.createStatement();
			ResultSet result = statement.executeQuery(sql);
			employees = new ArrayList<Employee>();
			while (result.next()) {
				Employee emp = new Employee();
				emp.setId(result.getInt("id"));
				emp.setFirstName(result.getString("firstname"));
				emp.setLastName(result.getString("lastname"));
				emp.setDepartment(result.getString("department"));
				emp.setSalary(result.getLong("salary"));
				employees.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}

	public static List<Employee> getEmployee(String value) {
		Connection con = JdbcPostgresqlConnection.getConnection();
		String sql;
		if(value.equalsIgnoreCase("id"))
		 sql = "SELECT * FROM EMPLOYEE WHERE id=?";
		
		if(value.equalsIgnoreCase("firstname"))
			sql = "SELECT * FROM EMPLOYEE WHERE firstname=?";
		
		if(value.equalsIgnoreCase("lastname"))
			sql = "SELECT * FROM EMPLOYEE WHERE lastname=?";
		
		if(value.equalsIgnoreCase("department"))
			sql = "SELECT * FROM EMPLOYEE WHERE department=?";
		
		if(value.equalsIgnoreCase("salary"))
			sql = "SELECT * FROM EMPLOYEE WHERE salary=?";
		else {
			return getAllEmployee();
		}
		PreparedStatement statement;
		value = value.toLowerCase();
		List<Employee> empList = new ArrayList<>();
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, value);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Employee emp = new Employee(result.getInt("id"), result.getString("firstname"), result.getString("lastname"),
						result.getString("department"), result.getInt("salary"));
				empList.add(emp);
			}
//			while (result.next()) {
//				emp = new Employee();
//	            emp.setId(result.getString(1));
//	            // or p.name=rs.getString("firstname"); by name of column
//	        }
//			emp = new Employee(result.getString("id"), result.getString("firstname"), result.getString("lastname"),
//					result.getString("department"), result.getLong("salary"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
	}

	public static String save(Employee emp) {
		Connection con = JdbcPostgresqlConnection.getConnection();
		String result = "";
		String sql = "INSERT INTO EMPLOYEE (id, firstname, lastname, department, salary, password) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			statement.setInt(1, emp.getId());
			statement.setString(2, emp.getFirstName());
			statement.setString(3, emp.getLastName());
			statement.setString(4, emp.getDepartment());
			statement.setLong(5, emp.getSalary());
			statement.setString(6, emp.getPassword());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				result = "A new Employee was inserted successfully!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = "Unable to add Employee!";
			e.printStackTrace();
		}
		return result;
	}

	public static String update(Employee emp) {
		Connection con = JdbcPostgresqlConnection.getConnection();
		String result = "";
		String sql = "UPDATE EMPLOYEE SET id =?,password=?, firstname=? lastname=?, departmemt=?, salary=?, WHERE id=?";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			statement.setInt(1, emp.getId());
			statement.setString(2, emp.getPassword());
			statement.setString(3, emp.getFirstName());
			statement.setString(4, emp.getLastName());
			statement.setString(5, emp.getDepartment());
			statement.setLong(6, emp.getSalary());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				result = "Employee uodated successfully!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = "Unable to update Employee!";
			e.printStackTrace();
		}
		return result;
	}

	public static String delete(String id) {
		Connection con = JdbcPostgresqlConnection.getConnection();
		String result = "";
		String sql = "DELETE FROM EMPLOYEE WHERE id=?";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, id);

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				result = "Employee was deleted successfully!";
			}
		} catch (SQLException e) {
			result = "Employee can't be deleted!";
			e.printStackTrace();
		}
		return result;
	}

}
