package com.rt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskOne 
{
		public static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
		public static final String username = "jdbc";
		public static final String password = "password";
		void main() {
			
				String create = 
						"""
						create table student_info(std_rollNo number(3) primary key, std_name varchar(50), std_percentage number(5,2),
						std_fname varchar(50), std_lname varchar(50), std_email varchar(100), std_number number(10))
						""";
				
			try(
					Connection conn = DriverManager.getConnection(url, username, password);
					Statement stmt = conn.createStatement();
				)
			{
				stmt.execute(create);
				IO.println("Table is created");
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
}
