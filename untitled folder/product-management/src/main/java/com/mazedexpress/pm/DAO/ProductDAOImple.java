package com.mazedexpress.pm.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Repository;

import com.mazedexpress.pm.api.Product;
import com.mazedexpress.pm.rowmapper.ProductRowMapper;
@Repository
public class ProductDAOImple implements ProductDAO{
	
	@Autowired
	private JdbcTemplate JdbcTemplate;
	@Override
	public List<Product> productList() {
		String sqlString="SELECT * FROM ProductManagement.products";
		List<Product> productsList=JdbcTemplate.query(sqlString, new ProductRowMapper());
		return productsList;
	}
	@Override
	public void saveProduct(Product product) {
		String sqlString="INSERT INTO products (productName,productCategory,productPrice,productQuantity,productSupplier) VALUES(?,?,?,?,?)";
		Object[] pramObject= {product.getProductName(),product.getProductCategory(),product.getProductPrice(),product.getProductQuantity(),product.getProductSupplier()};
		int rowAffected=JdbcTemplate.update(sqlString, pramObject);
		if (rowAffected>0) {
			System.out.println("Data Saved Successfully");
		}else {
			System.out.println("Sorry !! Please try again");
			
		}
		
	}
	@Override
	public void updateProduct(Product product) {
	
		String sqlString="UPDATE products SET productName=?, productCategory=?, productPrice=?, productQuantity=?, productSupplier=? WHERE id=?";
		int rowAffected=JdbcTemplate.update(sqlString, product.getProductName(),product.getProductCategory(),product.getProductPrice(),product.getProductQuantity(),product.getProductSupplier(),product.getId());
		if (rowAffected>0) {
			System.out.println("Data Updated Successfully");
		}else {
			System.out.println("Sorry !! Please try again");
			
		}
	}
	@Override
	public Product getProductById(int productId) {
		String sqlString="SELECT * FROM products WHERE id=?";
		Product productInfoById= JdbcTemplate.queryForObject(sqlString, new ProductRowMapper(), productId);
		return productInfoById;
	}
	@Override
	public void deleteProductById(int productId) {
		String sqlString="DELETE FROM products WHERE id=?";
		int rowAffected=JdbcTemplate.update(sqlString, productId);
		if (rowAffected>0) {
			System.out.println("Data Deleted Successfully");
		}else {
			System.out.println("Sorry !! Please try again");
			
		}
		
	}

}
