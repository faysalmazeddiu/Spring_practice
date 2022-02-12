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
		<h3 align="center">Novice List</h3>

		<i>Student will be here</i>
		
		<div align="center">
		<form action="/novice-management/showNoviceEntryPage" method="get">
			<button type="submit"> Add Novice</button>
		</form>
		<table border="1" >
		
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>mobile</td>
				<td>country</td>
				<td>ACTION</td>
			</tr>
			
			<c:forEach var="perNovice" items="${novices}">
			<tr>
				
				<td>${perNovice.id}</td>
				<td>${perNovice.name}</td>
				<td>${perNovice.mobile}</td>
				<td>${perNovice.country}</td>
				
				<td>
				 <a href="/novice-management/updateNovice?noviceId=${perNovice.id}">EDIT</a> |
				 <a href="/novice-management/deleteNovice?noviceId=${perNovice.id}">DELETE</a>
				 </td>
				
			</tr>
			</c:forEach>
		
		</table>
	</div>
</body>
</html>