<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/student-management/URLToReachResourcesFolder/css/style.css">
</head>
<body class="myBackGround">
	<h1 align="center">Add Student</h1>
	<table border="1" align="center">
		<form:form action="save-student" method="POST" modelAttribute="student">

			<tr>
			<td><form:hidden path="id" /></td>
			
			</tr>

			<tr>

				<td><label>NAME :</label></td>
				
				<td><form:input path="nameString" /></td>
			</tr>

			<tr>

				<td><label>MOBILE :</label></td>
				
				<td><form:input path="mobile" /></td>
			</tr>

			<tr>

				<td><label>COUNTRY :</label></td>
				
				<td><form:input path="country" /></td>
			</tr>

			<tr>

				<td></td>
				<td><input type="submit" value="SAVE" class="myButton"></td>
			</tr>



		</form:form>

	</table>
</body>
</html>