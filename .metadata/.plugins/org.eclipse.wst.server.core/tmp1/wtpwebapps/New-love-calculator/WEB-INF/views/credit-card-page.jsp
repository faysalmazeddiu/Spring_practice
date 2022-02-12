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
<h3 align="center">Credit Bill Payment</h3>
	<div align="center">
		<form:form modelAttribute="billInfo" method="post" action="process-creditcard">
		
		
		<table border="1">
			<tr>
					<td><label>Credit card Number</label></td>
					<td><form:input path="creditCard"/></td>
			
			</tr>
			
			<tr>
					<td>Amount</td>
					<td><form:input path="amount"/></td>
			
			</tr>
			
			<tr>
					<td></td>
				    <td><form:button type="submit">PayBill</form:button></td>
			</tr>
		
		</table>
		
	</form:form>
	</div>

</body>
</html>