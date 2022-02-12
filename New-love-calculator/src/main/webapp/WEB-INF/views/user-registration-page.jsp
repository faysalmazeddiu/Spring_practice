<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
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

<h2 align="center">Registration</h2>
<div align="center">
<form:form action="registration-success" method="post" modelAttribute="userReg">
<table border="1">

	
	
		<tr>
		
			<td> <label for="name">Name</label></td>
			<td>
				<form:input path="name" id="name"/>
				<form:errors path="name" cssClass="error"/>
			</td>
		
		</tr>
		
		<tr>
		
			<td> <label for="username">User name</label></td>
			<td>
				<form:input path="userName" id="username"/>
				<form:errors path="userName" cssClass="error"/>
			</td>
		
		</tr>
		
		<tr>
		
			<td> <label for="password">Password</label></td>
			<td>
				
				<form:password path="password" id="password"/>
			</td>
		
		</tr>
		
		
		 <tr>
		
			<td> <label for="country">Country</label></td>
			<td>
				<form:select path="countryName">
					<form:option value="USA" label="USA"></form:option>
					<form:option value="INDIA" label="India"></form:option>
					<form:option value="BANGLADESH" label="Bangladesh"></form:option>
				</form:select>
			</td>
		
		</tr>
		
		<tr>
		
			<td> <label for="hobbies">HOBBY</label></td>
			<td>
				CRICKET : <form:checkbox path="hobbies" value="cricket"/>
				READING :<form:checkbox path="hobbies" value="reading"/>
				TRAVEL :<form:checkbox path="hobbies" value="travel"/>
				PROGRAMMING :<form:checkbox path="hobbies" value="programming"/>
			</td>
		
		</tr>
		
		<tr>
		
			<td> <label for="gender">Gender</label></td>
			<td>
				MALE <form:radiobutton path="gender" value="male"/>
				FEMALE <form:radiobutton path="gender" value="female"/>
			</td>
			
		
		</tr> 
		
		<tr>
		
			<td> <label for="age">Age</label></td>
			<td>
				<form:input path="age" id="age"/>
				
				<form:errors path="age" cssClass="error"/>
			</td>
			
		
		</tr> 
		
		<tr>
				
			
				<td><label>Email</label></td>
				<td>
				
				<form:input path="communicationDTO.email"/>
				<form:errors path="communicationDTO.email" cssClass="error"/>
				
				</td>
		
				
		</tr>
		
		<tr>
				
			
				<td><label>Phone</label></td>
				<td><form:input path="communicationDTO.phone"/></td>
		
				
		</tr>
	
	
	<tr>
		
			<td> </td>
			<td>
				<form:button type="submit">Register</form:button>
			</td>
		
		</tr>






</table>
	
</form:form>

</div>

</body>
</html>