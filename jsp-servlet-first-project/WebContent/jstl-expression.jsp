<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="first_number" scope="page" value="300"></c:set>
	<c:set var="second_number" scope="page" value="300"></c:set>
	<c:out value="${Integer.parseInt(first_number)+ Integer.parseInt(second_number)}"></c:out>
	<c:out value="${param.amount}"></c:out>
	
	<%=request.getAttribute("databasen") %>
	<form action="jstl-expression.jsp" method="post">
		<input type="text" name="amount" value=""/>
		<input type="submit" name="btn" value="save"/>
		
	</form>
	
	<jsp:useBean id="employee" class="com.jspservlet.registration.model.Employee" scope="request">
	</jsp:useBean>
	<%-- <c:set target="employee" property="emp_email" value="mazed@gmail.com"></c:set> --%>
	<jsp:setProperty name="employee" property="emp_email" value="mazed@gmail.com"></jsp:setProperty>
	<%= employee.getEmp_email()%>
	<br/>
	<br/>
	// for loop<br/>
	<c:forEach var="i" begin="0" end="10" step="2">
			${i}
	</c:forEach>
	
	<br/>
	<br/>
	//logical<br/>
	<c:set var="number" scope="page" value="300"></c:set>
	<c:if test="${ Integer.parseInt(number)>200}">
		<c:out value="Condition true"/>
	</c:if>
</body>
</html>