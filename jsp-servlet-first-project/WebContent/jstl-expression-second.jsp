<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h3>Hello , ${param.email}</h3>
<body>
 	<form action="jstl-expression-second.jsp" method="post">
 	<input type="text" name="email" value=""/>
 	<input type="submit" name="btn" value="save"/>
 	
 	</form>
 	<table border="1">
 	
 	<tr>
 		<td>Concept</td>
 		<td>EL Expression</td>
 		<td>Result</td>
 	
 	</tr>
 	<c:set var="value" scope="page" value="1"></c:set>
 	<c:forEach var="x" begin="1" end="10" step="1">
 	
 	<c:if test="${x==1}">
 	 <tr>
 	   <td>${Integer.parseInt(value)}</td>
 		<td>Literal</td>
 		<td><%=  "${10}" %></td>
 		<td>${10}</td>
 	</tr>
 	</c:if>
 	<c:if test="${x==2}">
 	<tr>
 		<td>${value=value+1}</td>
 		<td>Addition</td>
 		<td><%=  "${10+10}" %></td>
 		<td>${10+10}</td>
 		</tr>
 	</c:if>	
 	<c:if test="${x==3}">
 	<tr>
 		<td>${value=value+1}</td>
 		<td>Multiplication</td>
 		<td><%=  "${10*10}" %></td>
 		<td>${10*10}</td>
 		</tr>
 	</c:if>	
 	
 	<c:if test="${x==4}">
 	<tr>
 		<td>${value=value+1}</td>
 		<td>Divide</td>
 		<td><%=  "${100/3} or ${100 div 3} " %></td>
 		<td>${100 div 3}</td>
 		</tr>
 	</c:if>	
 	
 	<c:if test="${x==5}">
 	<tr>
 		<td>${value=value+1}</td>
 		<td>Modulus</td>
 		<td><%=  "${10 % 3} or ${10 mod 3} " %></td>
 		<td>${100 mod 3}</td>
 		</tr>
 	</c:if>	
 	
 	<c:if test="${x==6}">
 	<tr>
 		<td>${value=value+1}</td>
 		<td>Precedence</td>
 		<td><%=  "${10*10 mod 3}" %></td>
 		<td>${10*10 mod 3}</td>
 		</tr>
 	</c:if>	
 	
 	<c:if test="${x==7}">
 	<tr>
 		<td>${value=value+1}</td>
 		<td>Precedence with parents</td>
 		<td><%=  "${10* (10 mod 3)}" %></td>
 		<td>${10* (10 mod 3)}</td>
 		</tr>
 	</c:if>	
 	
 		<c:if test="${x==8}">
 	<tr>
 		<td>${value=value+1}</td>
 		<td>Exponent</td>
 		<td><%=  "${2E2}" %></td>
 		<td>${2E2}</td>
 		</tr>
 	</c:if>	
 	<tr>
 	
 	</c:forEach>
 	
 	</table>
 	
 	logical operator expression <br/>
 	<c:set var="first_number" scope="page" value="100"></c:set>
 	<c:set var="second_number" scope="page" value="50"></c:set>
 	${ "${200 > 50"}}======> ${first_number>second_number}<br/>
 	${ "${200 < 50"}}======>${first_number<second_number}<br/>
 	${ "${2/3 >= 3/2"}}======>${2/3 >= 3/2}<br/>
 	${ "${empty second_number"}}======>${empty first_number}<br/>
 	
 	gettig data form Servlet <br/>
 	
 	${database}<br/>
 	${username}<br/>
	${password}<br/> 	
 	
 	
 	
 	
 	
 	
</body>
</html>