<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<h3>Edit Employee</h3>

<form action="<%=request.getContextPath() %>/update" method="post">

<table border="1" >
	<input type="text" name="emp_id" value="${employee_info.emp_id }"/>
	<tr>
		<td> Name</td>
		<td><input type="text" name="emp_name" value="${employee_info.emp_name }"/></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><input type="text" name="emp_email" value="${employee_info.emp_email }"/></td>
	</tr>
	<tr>
		<td>Address</td>
		<td><input type="text" name="emp_addres" value="${employee_info.emp_addres }"/></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="text" name="emp_mobile" value="${employee_info.emp_mobile }"/></td>
	</tr>
	
	<tr>
		<td></td>
		<td><input type="submit" name="btn" value="SAVE"/></td>
	</tr>
</table>

</form>
</div>

</body>
</html>