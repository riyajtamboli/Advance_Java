package com.rt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertIntoTable {

	public static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String username = "jdbc";
	public static final String password = "password";
	public static void main(String[] args) {
		
		String insert = 
			"""
				insert into Employee(
				EMP_ID, EMP_NAME, DEPARTMENT, SALARY) values
				(?,?,?,?)
			""";
		try
		(
				Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement psmt = conn.prepareStatement(insert);
				
		)
		{
			String ch;
			do{
				int emp_id = Integer.parseInt(IO.readln("Enter Emp Id : "));
				String emp_name = IO.readln("Enter Emp Name : ");
				String dept = IO.readln("Enter Emp Department : ");
				double salary = Double.parseDouble(IO.readln("Enter Salary : "));
				psmt.setInt(1, emp_id);
				psmt.setString(2, emp_name);
				psmt.setString(3, dept);
				psmt.setDouble(4, salary);
				int rowAffected = psmt.executeUpdate();
				if(rowAffected > 0) {
					IO.println("Data Added Sucessfully.");
				}else {
					IO.print("Data not Added");
				}
				ch = IO.readln("Do you want to add more ? : ");
				
			}while(ch.equalsIgnoreCase("yes"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
