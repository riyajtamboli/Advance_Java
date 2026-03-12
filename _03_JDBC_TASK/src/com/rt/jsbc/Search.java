package com.rt.jsbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Search {
	
	public static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String username = "jdbc";
	public static final String password = "password";
	
	public static void main(String[] args) {
		String search =
				"""
				select *from product where PRODUCT_ID = ?
				""";
		try
		(
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement psmt = conn.prepareStatement(search);
		){
			int id = Integer.parseInt(IO.readln("Enter id to Search : "));
			psmt.setInt(1, id);
			ResultSet rs =  psmt.executeQuery();
			
			while(rs.next()) {
				if(id == rs.getInt(1)) {
					IO.println(rs.getString(1));
					IO.println("product found");
				}else {
					IO.println("Not");
				}
			}
		
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
