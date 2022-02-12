<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String sessionValue=(String)session.getAttribute("username");
if(sessionValue != null){	
%>

<p><a href="<%=request.getContextPath() %>/LogoutServlet">Logout</a></p>
	
<%	
}
%>

	<div align="center">
<h3>Login Form</h3>
<form action="<%=request.getContextPath() %>/LoginServlet" method="post">

<table border="1" >
		<tr>
		<td>User Name</td>
		<td><input type="text" name="username" value=""/></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="text" name="password" value=""/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" name="btn" value="Login"/>
		<p><a href="<%=request.getContextPath() %>/RegistrationServlet">Registration</a></p></td>
	</tr>
</table>

</form>
</div>
</body>
</html>