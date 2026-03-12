package com.product.service;

import java.util.List;
import com.product.bean.Product;
public interface ProductDao {
		int addProduct(Product product);
		int updateProduct(Product product);
		int deleteProduct(int id);
		Product getProductById(int id);
		List<Product> getAllProducts();
}
