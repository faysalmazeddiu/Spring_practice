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
<h2>HI ${userInfoDTO.userName}</h2>
<div align="center">
	
	<h4>Send Result to Your Email</h4>
	<form:form action="process-email" method="post" modelAttribute="emailInfo">
			
			<label>Your email id</label>
			<form:input path="emailAddress"/><br>
			
			<form:button type="submit">Send Email</form:button>
			
	
	</form:form>

</div>

</body>
</html>