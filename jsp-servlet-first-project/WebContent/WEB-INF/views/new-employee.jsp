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
<h3>Add Employee</h3>

<form action="<%=request.getContextPath() %>/insert" method="post">

<table border="1" >
	<tr>
		<td> Name</td>
		<td><input type="text" name="emp_name" value=""/></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><input type="text" name="emp_email" value=""/></td>
	</tr>
	<tr>
		<td>Address</td>
		<td><input type="text" name="emp_addres" value=""/></td>
	</tr>
	<tr>
		<td>Mobile</td>
		<td><input type="text" name="emp_mobile" value=""/></td>
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