package com.rt.jsbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InventaryManageMent 
{
	public static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String username = "jdbc";
	public static final String password = "password";
	public static void main(String args[]) {
		String createTable =
				"create table Product (PRODUCT_ID NUMBER, PRODUCT_NAME VARCHAR2(50), CATEGORY VARCHAR2(50),PRICE NUMBER)";
		try
		(
				Connection conn = DriverManager.getConnection(url, username, password);
				Statement stmt =conn.createStatement();
				
		)
		{
			int rowAffected =  stmt.executeUpdate(createTable);
			if(rowAffected> 0) {
				IO.println("Table creates successfully.");
			}else {
				System.err.println("Something wrong happend");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
