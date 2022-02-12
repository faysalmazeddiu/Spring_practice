package com.mazedexpress.pm.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mazedexpress.pm.api.Product;

public class ProductRowMapper implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Product product=new Product();
		product.setId(rs.getInt("id"));
		product.setProductName(rs.getString("productName"));
		product.setProductCategory(rs.getInt("productCategory"));
		product.setProductPrice(rs.getDouble("productPrice"));
		product.setProductQuantity(rs.getInt("productQuantity"));
		product.setProductSupplier(rs.getString("productSupplier"));
		return product;
	}

}
