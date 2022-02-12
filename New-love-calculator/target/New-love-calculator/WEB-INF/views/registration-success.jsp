<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 align="center"> Registration Successfully Completed</h3>
<h3 align="center">The details entered by you are :</h3>
<div align="center">

		Name : ${userReg.name}<br/>
		User Name : ${userReg.userName}<br/>
		
		Password : 
		
		<c:forEach var="cn" items="${userReg.password}">
				${cn}
		
		</c:forEach>
		<br/>
		Country Name : ${userReg.countryName} <br/>
		Age : ${userReg.age} <br/>
		
		Hobbies : 
		<c:forEach var="temp" items="${userReg.hobbies}">
				${temp}
		
		</c:forEach><br/>
		Gender : ${userReg.gender} <br/>
		
		Email : ${userReg.communicationDTO.email} <br/>
		
		Phone : ${userReg.communicationDTO.phone}


</div>
</body>
</html>