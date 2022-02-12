<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Novice Entry Page</h2>
<div align="center">
<table border="1">

<form:form modelAttribute="student" action="save-novice" method="post">
		<form:hidden path="noviceId"/>
		<tr>
			<td>Name </td>
			<td><form:input path="studentNameString"/></td>
	   </tr>
	   
	   <tr>
			<td>Mobile </td>
			<td><form:input path="studentMobile"/></td>
	   </tr>
	   
	   <tr>
			<td>Country </td>
			<td><form:input path="countryString"/></td>
	   </tr>

		<tr>
			<td> </td>
			<td><form:button type="submit"> Add </form:button></td>
	   </tr>
</form:form>
	

</table>
</div>
</body>
</html>