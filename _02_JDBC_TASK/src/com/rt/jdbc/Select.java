package com.rt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
	public static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String username = "jdbc";
	public static final String password = "password";
	
	public static void main(String[] args) {
			String select = "select *from Employee";
		try
		(
				Connection conn = DriverManager.getConnection(url, username, password);
				Statement stmt = conn.createStatement();
				
		){
			
			ResultSet rs =stmt.executeQuery(select);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int columnCount = rsmd.getColumnCount();
			IO.println("--------------------------------------------------------------");
			for(int i=1; i<=columnCount; i++) {
				System.out.printf("%-25s",rsmd.getColumnName(i));
			}
			IO.println();
			IO.print("--------------------------------------------------------------");
			IO.println();
			while(rs.next()) {
				for(int i=1; i<columnCount; i++) {
					System.out.printf("%-25s",rs.getString(i));
				}
				IO.println();
			}
			IO.print("--------------------------------------------------------------");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
