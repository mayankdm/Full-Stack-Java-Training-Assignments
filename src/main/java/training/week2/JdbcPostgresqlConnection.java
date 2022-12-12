package training.week2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcPostgresqlConnection {
	private static Connection conn = null;
	private static final String url = "jdbc:postgresql://localhost:5432/db1";
	private static final String user = "postgres";
	private static final String password = "root";

	public static Connection getConnection() {
		if (conn != null) {
			return conn;
		}
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the PostgreSQL server successfully.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if (conn != null) {
			System.out.println("Connected to postgres!");
		}
		return conn;
	}

	public static void createTable() {
		try {
			DatabaseMetaData dbm = getConnection().getMetaData();
			ResultSet isTable = dbm.getTables(null, null, "employee", null);
			if (!isTable.next()) {
				String query = "CREATE TABLE EMPLOYEE(" + "ID INT NOT NULL, " + "FIRSTNAME VARCHAR (20) NOT NULL, "
						+ "LASTNAME VARCHAR (20) NOT NULL, " + "SALARY DECIMAL (18, 2), " + "PASSWORD VARCHAR (255), " + "DEPARTMENT VARCHAR (25))";
				Statement stmt = null;
				stmt = getConnection().createStatement();
				stmt.execute(query);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Table Created......");
	}

	public static void main(String[] args) {
		createTable();
	}
}
