<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<h4 >Login Successful</h4>
		<p><a href="<%=request.getContextPath() %>/LogoutServlet">Logout</a></p>
		<a href="EmployeeServlet">Employee List</a>
	
</body>
</html>