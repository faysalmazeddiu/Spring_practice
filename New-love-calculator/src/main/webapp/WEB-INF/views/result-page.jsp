<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3> Love Calculator</h3>
	
		<p align="center">The love calculator Prediction :</p>
		<p> ${userInfoDTO.userName} and ${userInfoDTO.crashName} both are ${appResult}</p>
		
	
	</div>
	<div>
		<!-- for sending data by url  ::::  -->
		<%-- <a href="/New-love-calculator/sendEmail/${userInfoDTO.userName}">Send result to email</a><br> --%>
		
		
		<!-- <a href="/New-love-calculator/sendEmail">Send result to email</a><br> -->
		
		
		<!-- when cookies are desabled that time <c:url value=""/> tag autmetically track session data -->
		<a href="<c:url value="sendEmail"/>">Send result to email</a><br> 
		
		<a href="/New-love-calculator/sendEmail">Try Some Body else</a>
	
	</div>
	
</body>
</html>