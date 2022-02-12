<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	.error{
		color:red;
		/* position:fixed; */
		text-align:left;
		/* //margin-left:30px; */
	
	}

</style>
</head>
<body>

<h3 align="center">Credit Bill Payment</h3>
	<div align="center">
		<form:form modelAttribute="billInfo" method="post" action="process-payment">
		
		
		<table border="1">
			<tr>
					<td><label>Credit card Number</label></td>
					<td>
					<form:input path="creditCard"/>
					<form:errors path="creditCard" cssClass="error"/>
					</td>
			
			</tr>
			
			<tr>
					<td>Amount</td>
					<td><form:input path="amount"/>
					<form:errors path="amount" cssClass="error"/>
					</td>
			
			</tr>
			
			<tr>
					<td>Currency</td>
					<td><form:input path="currency"/>
					<form:errors path="currency" cssClass="error"/>
					</td>
			
			</tr>
			
			<tr>
					<td>Date</td>
					<td><form:input path="date"/>
					<form:errors path="date" cssClass="error"/>
					</td>
			
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