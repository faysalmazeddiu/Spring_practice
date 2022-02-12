package com.mazedexpress.pm.api;

public class Product {
	private int id;
	private String productName;
	private int productCategory;
	private double productPrice;
	private int productQuantity;
	private String productSupplier;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getProductSupplier() {
		return productSupplier;
	}
	public void setProductSupplier(String productSupplier) {
		this.productSupplier = productSupplier;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productCategory=" + productCategory
				+ ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + ", productSupplier="
				+ productSupplier + "]";
	}
	
	
}
