package com.product.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.product.bean.Product;
import com.product.utility.Utility;

public class ProductDaoImpl implements ProductDao{
	
	@Override
	public int addProduct(Product p) {
			
		String insert = 
			"""
			insert into product ( id, name, price, quantity) values(?,?,?,?)
			""";
		
		int result = 0;
		try(
				Connection conn = Utility.getConnection();
				PreparedStatement psmt = conn.prepareStatement(insert);
				
		)
		{
			psmt.setInt(1, p.getId());
			psmt.setString(2, p.getName());
			psmt.setDouble(3, p.getPrice());
			psmt.setInt(4, p.getQuantity());
			 result = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	@Override
	public int updateProduct(Product product) {
		String update = 
			"""
				update product set name = ?, price = ?, quantity= ? where id = ?
						""";
			int result = 0;
		try(
				Connection conn = Utility.getConnection();
				PreparedStatement psmt = conn.prepareStatement(update);
			)
		{
			
			psmt.setString(1, product.getName());
			psmt.setDouble(2, product.getPrice());
			psmt.setInt(3, product.getQuantity());
			psmt.setInt(4, product.getId());
			result = psmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	@Override
	public int deleteProduct(int id) {
		

	    String delete = "delete from product where id = ?";
	    int result = 0;

	    try(
	        Connection conn = Utility.getConnection();
	        PreparedStatement psmt = conn.prepareStatement(delete);
	    ){
	        psmt.setInt(1, id);
	        result = psmt.executeUpdate();

	        System.out.println("Rows affected = " + result); // debug

	    }catch(SQLException e){
	        e.printStackTrace();
	    }

	    return result;
	}
	@Override
	public Product getProductById(int id) {

		String selectById = 
				"""
				select * from product where id = ?
				""";
		
			Product product = null;
		try
		(
				Connection conn = Utility.getConnection();
				PreparedStatement psmt = conn.prepareStatement(selectById);
		) 
		{
			
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				product = new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getInt(4)
						);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return product;
		
	}
	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		products.clear();

		String selectAll = "Select * from product";
		
		try
		(
				Connection conn = Utility.getConnection();
				PreparedStatement psmt = conn.prepareStatement(selectAll);
		)
	
		{
			ResultSet rs =psmt.executeQuery();
			
			while(rs.next()) {
				products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity")));
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return products;
				
	}
	
	
}
