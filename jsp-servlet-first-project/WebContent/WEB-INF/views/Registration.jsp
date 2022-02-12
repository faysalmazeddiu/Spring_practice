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
<h3>Registration Form</h3>
<p><a href="LoginServlet">Login</a></p>
<form action="<%=request.getContextPath() %>/RegistrationServlet" method="post">

<table border="1" >
	<tr>
		<td>First Name</td>
		<td><input type="text" name="first_name" value=""/></td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td><input type="text" name="last_name" value=""/></td>
	</tr>
	<tr>
		<td>User Name</td>
		<td><input type="text" name="username" value=""/></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="text" name="password" value=""/></td>
	</tr>
	<tr>
		<td>Address</td>
		<td><input type="text" name="address" value=""/></td>
	</tr>
	<tr>
		<td>Contact</td>
		<td><input type="text" name="contact" value=""/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" name="btn" value="Register"/></td>
	</tr>
</table>

</form>
</div>

</body>
</html>