package com.rt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertIntoTable {
	public static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String username = "jdbc";
	public static final String password = "password";
	void main() 
	{
		String insert = 
				"""
				insert into student_info(std_rollNo, std_name, std_percentage,
						std_fname, std_lname, std_email, std_number)values(?,?,?,?,?,?,?)
				""";
		try
		(
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement psmt = conn.prepareStatement(insert);
		)
		{
		
			String op;
			do {
			int rollNo = Integer.parseInt(IO.readln("Enter Roll NO : "));
			String studentName = (IO.readln("Enter Name : "));
			double percentage = Double.parseDouble(IO.readln("Enter percentage : "));
			String fName = IO.readln("Enter First Name : ");
			String lName = IO.readln("Enter Last Name : ");
			String email = IO.readln("Enter Email : ");
			long number = Long.parseLong(IO.readln("Enter Number : "));
			
			psmt.setInt(1, rollNo);
			psmt.setString(2, studentName);
			psmt.setDouble(3, percentage);
			psmt.setString(4, fName);
			psmt.setString(5, lName);
			psmt.setString(6, email);
			psmt.setLong(7, number);
			psmt.executeUpdate();
			IO.println("Data inserted successfull.");
			op = IO.readln("Do you want add more : ");
			}while(op.equalsIgnoreCase("yes"));	
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
