<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Payment success page</h1>
<div align="center">

	<p>Payment Amount : ${billInfo.amount}</p><br/> 
	<p>Payment Currency : ${billInfo.currency.getDisplayName()}</p><br/> 
	<p>Payment Date : ${billInfo.date}</p><br/> 
	<p>Payment Credit Card Number :
			${billInfo.creditCard}
	</p><br/> 

</div>

</body>
</html>