<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<a href="allEmployee">List of Employee</a>
		<h2 align="center">Employee Insert</h2>
		<div align="center">
		
		<table border="1">
		<form:form  modelAttribute="employee" method="post" action="insertEmployee">
				<form:hidden path="emp_id"/>
				<tr>
				
					<td>Employee Name</td>
					<td><form:input path="emp_name"/></td>
				
				</tr>
				
				<tr>
				
					<td>Employee Address</td>
					<td><form:input path="emp_address"/></td>
				
				</tr>
				<tr>
					
					<td>Employee DateOfBirth</td>
					<td><form:input path="emp_dob"/></td>
				
				</tr>
				<tr>
				
					<td>Employee Mobile</td>
					<td><form:input path="emp_mobile"/></td>
				
				</tr>
			
				<tr>
				
				<td></td>
				<td>
				<c:if test="${employee.emp_id==0}">
					<form:button type="submit">SAVE Employee</form:button>
				</c:if>
				<c:if test="${employee.emp_id !=0}">
					<form:button type="submit">Update Employee</form:button>
				</c:if>	
			
				
				</td>
				
				
				</tr>
			
			</form:form>
		
		
		
		</table>
			
		
		
		</div>
</body>
</html>