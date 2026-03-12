package com.rt.jsbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTable {
	
	public static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String username = "jdbc";
	public static final String password = "password";
	public static void main(String[] args) {
		String insert = 
				"""
				insert into Product(PRODUCT_ID,PRODUCT_NAME,CATEGORY, PRICE)
				values(?,?,?,?)
				""";
		try
		(
				Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement psmt = conn.prepareStatement(insert);
		)
		{
			String ch;
			do {
			int productId= Integer.parseInt(IO.readln("Enter id : "));
			String productName = IO.readln("Enter Product Name : ");
			String category = IO.readln("Enter Category Name : ");
			double price = Double.parseDouble(IO.readln("Enter Price : "));
			psmt.setInt(1, productId);
			psmt.setString(2, productName);
			psmt.setString(3, category);
			psmt.setDouble(4, price);
			int rowAffected = psmt.executeUpdate();
			if(rowAffected > 0) {
				IO.println(rowAffected+" Rows Affected.");
			}else {
				System.err.println("Not inserted");
			}
				ch = IO.readln("Do you want add more ? : ");
			}while(ch.equalsIgnoreCase("yes"));
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
