package com.rt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class EmployeeDatabaseApp {
	public static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String username = "jdbc";
	public static final String password = "password";
	void main() {
		
		String create =
				"""
				create table Employee(EMP_ID NUMBER, 
				EMP_NAME	VARCHAR2(50), DEPARTMENT VARCHAR2(50), SALARY	NUMBER)
				""";
		try
		(
			Connection conn = DriverManager.getConnection(url, username, password);
				Statement stmt = conn.createStatement();
		)
		{
			stmt.executeUpdate(create);
			IO.println("Table creatd successgully.");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
