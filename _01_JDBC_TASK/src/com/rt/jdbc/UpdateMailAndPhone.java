package com.rt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateMailAndPhone {
	public static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String username = "jdbc";
	public static final String password = "password";
	void main() 
	{
		String update =
				"""
				update student_info set STD_EMAIL=?, STD_NUMBER= ? where STD_ROLLNO=?
				""";
		try
		(
				Connection conn =DriverManager.getConnection(url, username, password);
				PreparedStatement psmts =conn.prepareStatement(update);
		)
		{
			String email = IO.readln("Enter Email to Update : ");
			long number = Long.parseLong(IO.readln("Enter Number to update : "));
			int rollNo = Integer.parseInt(IO.readln("Enter RollNo : "));
			psmts.setString(1, email);
			psmts.setLong(2, number);
			psmts.setInt(3, rollNo);
			int rowAffected  =psmts.executeUpdate();
			if(rowAffected>0) {
				IO.println(rowAffected+" Row Updated");
			}else {
				IO.println("Not Updated");
			}
		}catch(SQLException e) {
			e.printStackTrace();;
		}
	}
}
