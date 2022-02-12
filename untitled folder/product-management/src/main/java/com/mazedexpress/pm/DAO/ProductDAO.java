package com.mazedexpress.pm.DAO;

import java.util.List;

import com.mazedexpress.pm.api.Product;

public interface ProductDAO {
	
	List<Product> productList();
	void saveProduct(Product product);
	void updateProduct(Product product);
	Product getProductById(int productId) ;
	void deleteProductById(int productId);

}
