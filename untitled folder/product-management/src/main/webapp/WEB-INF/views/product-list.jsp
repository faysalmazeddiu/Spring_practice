<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Product List</h2>

<div align="center">

<form action="showEntryPage">
	<input type="submit" value="ADD PRODUCT">

</form>

<table border="1" align="center">
		<thead>
		<tr>
			<td>ID</td>
			<td> NAME</td>
			<td> CATEGORY</td>
			<td> PRICE</td>
			<td> QUANTITY</td>
			<td> SUPPLIER</td>
			<td>ACTION</td>
		</tr>
		
		</thead>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.id}</td>
				<td>${product.productName}</td>
				<td>${product.productCategory}</td>
				<td>${product.productPrice}</td>
				<td>${product.productQuantity}</td>
				<td>${product.productSupplier}</td>
				<td>
					<a href="updateProduct?productId=${product.id}">Edit</a> |
					<a href="deleteProduct?productId=${product.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
</table>

</div>

</body>
</html>