package com.rt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowStudent 
{	
	public static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String username = "jdbc";
	public static final String password = "password";

	public static void main(String[] args)
	{
		String query = "select * from student_info where STD_PERCENTAGE > 60";

		try(
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
		){
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

	
			for(int i=1; i<=columnCount; i++) {
				System.out.printf("%-20s", rsmd.getColumnName(i));
			}
			System.out.println();

			for(int i=1; i<=columnCount; i++) {
				System.out.print("--------------------");
			}
			System.out.println();

			while(rs.next()) {
				for(int i=1; i<=columnCount; i++) {
					System.out.printf("%-20s", rs.getString(i));
				}
				System.out.println();
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}