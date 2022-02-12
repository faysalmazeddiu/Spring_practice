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
		<h3> Love Calculator</h3>
	
		<p align="center">The love calculator Prediction :</p>
		<p> ${userInfoDTO.userName} and ${userInfoDTO.crashName} both are friends</p>
		
	
	</div>
	<div>
		<!-- for sending data by url  ::::  -->
		<%-- <a href="/New-love-calculator/sendEmail/${userInfoDTO.userName}">Send result to email</a><br> --%>
		
		<a href="/New-love-calculator/sendEmail">Send result to email</a><br>
		<a href="/New-love-calculator/sendEmail">Try Some Body else</a>
	
	</div>
	
</body>
</html>