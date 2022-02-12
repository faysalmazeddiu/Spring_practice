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
<p>${message}</p>
<p><a href="employeeEntryPage">Insert Employee</a></p>
<p>Employee List</p>
<table border="1">

	<tr>
		<td>Employee Name</td>
		<td>Employee Address</td>
		<td>Employee DOB</td>
		<td>Employee Mobile</td>
		<td>Action</td>
	</tr>
	
	<c:forEach var="emplyeeInfo" items="${employeeList}">
	
			<tr>
				<td>${emplyeeInfo.emp_name}</td>
			
				<td>${emplyeeInfo.emp_address}</td>
				<td>${emplyeeInfo.emp_dob}</td>
				<td>${emplyeeInfo.emp_mobile}</td>
			
				<td>
				
					<a href="updateEmployee?empId=${emplyeeInfo.emp_id}">EDIT</a> |
					<a href="deleteEmployee?empId=${emplyeeInfo.emp_id}">DELETE</a>
				
				
				</td>
			
			</tr>
	
	
	</c:forEach>
	


</table>
</div>
</body>
</html>