<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/student-management/URLToReachResourcesFolder/css/style.css">
</head>
<body class="myBackGround myFont">
    <!-- <i>Student data coming soon</i> -->
    <h1 align="center">MazedExpress</h1>
    <div align="center">
    
    <form action="studentEntryPage">
    
    	<input type="submit" value="ADD" class="myButton">
    
    </form>
    
     <table border="1" align="center">
    
    <thead>
    	<tr>
	    	<td>ID</td>
	    	<td>Name</td>
	    	<td>MOBILE</td>
	    	<td>COUNTRY</td>
	    	<td>ACTION</td>
    	</tr>
    
    </thead>
    
    
    <c:forEach var="student" items="${allStudents}">
    		<tr>
    			<td>${student.id}</td>
    			<td>${student.nameString}</td>
    			<td>${student.mobile}</td>
    			<td>${student.country}</td>
    			<td><a href="updateStudent?userId=${student.id}">Update</a></td>
    			<td><a href="deleteStudent?userId=${student.id}" onclick="if(confirm('Are you sure want to delete this record')){return true;}else{return false;}">Delete</a></td>
    		</tr>
    </c:forEach>
    </table>
    
    <img alt="" src="/student-management/URLToReachResourcesFolder/images/download.jpg">
    
    </div>
   
  
</body>
</html>