package Utility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
	private static Connection con = null; // sql
	private static Connection conn = null; // mysql

	// SQL Server
	public static void setDbConnection() throws SQLException,
			ClassNotFoundException {
		try {
			Class.forName(TestConfig.driver);
			con = DriverManager.getConnection(TestConfig.dbConnectionUrl,
					TestConfig.dbUserName, TestConfig.dbPassword);

			if (!con.isClosed())
				System.out.println("Successfully connected to SQL server");

		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());

			// monitoringMail.sendMail(TestConfig.server, TestConfig.from,
			// TestConfig.to,
			// TestConfig.subject+" - (Script failed with Error, Datamart database used for reports, connection not established)",
			// TestConfig.messageBody, TestConfig.attachmentPath,
			// TestConfig.attachmentName);
		}

	}

	// MySQL server
	public static void setMysqlDbConnection() throws SQLException,
			ClassNotFoundException {
		try {

			Class.forName(TestConfig.mysqldriver);
			conn = DriverManager.getConnection(TestConfig.mysqlurl,
					TestConfig.mysqluserName, TestConfig.mysqlpassword);

			if (!conn.isClosed())
				System.out.println("Successfully connected to MySQL server");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.err.println("Cannot connect to database server");

		}

	}

	public static List<String> getQuery(String query) throws SQLException {

		// String Query="select top 10* from ev_call";
		Statement St = con.createStatement();
		ResultSet rs = St.executeQuery(query);
		List<String> values = new ArrayList<String>();
		while (rs.next()) {

			values.add(rs.getString(1));

		}
		return values;
	}

	public static List<String> getMysqlQuery(String query) throws SQLException {

		Statement St = conn.createStatement();
		ResultSet rs = St.executeQuery(query);
		List<String> values1 = new ArrayList<String>();
		while (rs.next()) {

			values1.add(rs.getString(1));

		}
		return values1;
	}

	public static Connection getConnection() {
		return con;
	}
}