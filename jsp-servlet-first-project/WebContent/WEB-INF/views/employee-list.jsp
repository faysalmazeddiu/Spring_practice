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
<h1>Employee List</h1>
<table border="1">
<tr>

<td>Name</td>
<td>Address</td>
<td>Email</td>
<td>Mobile</td>
<td>Action</td>

</tr>
<c:forEach var="employee_info" items="${allEmployee}">

<tr>
<td>${employee_info.emp_name}</td>
<td>${employee_info.emp_addres}</td>
<td>${employee_info.emp_email}</td>
<td>${employee_info.emp_mobile}</td>
<td>
	<a href="<%=request.getContextPath() %>/edit?empId=${employee_info.emp_id}">Edit</a> |
	<a href="<%=request.getContextPath() %>/delete?empId=${employee_info.emp_id}">Delete</a>

</td>

</tr>



</c:forEach>



</table>

</body>
</html>