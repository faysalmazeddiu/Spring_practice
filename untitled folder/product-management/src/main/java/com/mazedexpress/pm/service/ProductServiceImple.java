package com.mazedexpress.pm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazedexpress.pm.DAO.ProductDAO;
import com.mazedexpress.pm.api.Product;

@Service
public class ProductServiceImple implements ProductService{
	
	@Autowired
	ProductDAO productDAO;
	
	@Override
	public List<Product> productList() {
		return productDAO.productList();
	}
	@Override
	public void saveProduct(Product product) {
		productDAO.saveProduct(product);
		
	}
	@Override
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);
		
	}
	@Override
	public Product getProductById(int productId) {
		return productDAO.getProductById(productId);
	}
	@Override
	public void deleteProductById(int productId) {
		productDAO.deleteProductById(productId);
		
	}

}
