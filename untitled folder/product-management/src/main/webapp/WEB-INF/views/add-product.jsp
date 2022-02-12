<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h2 align="center">PRODUCT ENTRY PAGE</h2>
	<table border="1" align="center">
	
	<form:form action="saveProduct" method="POST" modelAttribute="product">
			<form:input path="id"/>
			<tr>
				<td>Product Name</td>
				<td><form:input path="productName"/></td>
			</tr>
	
		<tr>
				<td>Product Category</td>
				<td>
				
				<%-- <form:input path="productCategory"/> --%>
				 <form:select path="productCategory">
				 	<form:option value="1">Electric</form:option>
					 <form:option value="2">Dress</form:option>
					 <form:option value="3">Liquid</form:option>
				 </form:select>
				
				</td>
			</tr>
			<tr>
				<td>Product price</td>
				<td><form:input path="productPrice"/></td>
			</tr>
			<tr>
				<td>Product Quantity</td>
				<td><form:input path="productQuantity"/></td>
			</tr>
			<tr>
				<td>Product Supplier</td>
				<td><form:input path="productSupplier"/></td>
			</tr>
			<tr>
				<td></td>
				<td>
				<jsp:useBean id="product" class="com.mazedexpress.pm.api.Product" scope="request"></jsp:useBean>
				<% if(product.getId() ==0){%>
				<form:button type="submit">SAVE</form:button>
				<% } else{%>
				<form:button type="submit">Update</form:button>
				<%} %>
				</td>
			</tr>
	
	</form:form>
	
	
	</table>
	
	</div>
</body>
</html>