<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<style type="text/css">

	.error{
		color:red;
		/* position:fixed; */
		text-align:left;
		/* //margin-left:30px; */
	
	}

</style>
<script type="text/javascript">

	function validateUserName(){
		
		var userName=document.getElementById("un").value;
		var crashName=document.getElementById("cn").value;
		if(userName.length<3 ){ 
			alert("username and crashname should be more than 3 charecter");
			return false;
		}
		return true;
		
	}


</script>
</head>
<body>
<h2 align="center">LOVE CALCULATOR</h2>
<div align="center">

<form:form action="process-homepage" method="get" modelAttribute="userInfoDTO">
	     <table >
	     <tr>
	     		<td><label for="un">Your Name</label></td>
	     		<td>
	     			<!-- <input type="text" name="userName" id="un"/> -->
	     			<form:input  path="userName" id="un"/>
	     			
	     		</td>
	     		
	     		<td>
	     			<form:errors path="userName" cssClass="error"/>
	     		</td>
	     </tr>
	      <tr>
	     		<td><label for="cn">Crush Name</label></td>
	     		<td>
	     			<!-- <input type="text" name="crashName" id="cn"/> -->
	     			<form:input  path="crashName" id="cn"/>
	     			
	     		
	     		</td>
	     		<td>
	     			<form:errors path="crashName" cssClass="error"/>
	     		</td>
	     </tr>
	     <tr>
	     
	     		
	     		<td>
	     			<!-- <input type="text" name="crashName" id="cn"/> -->
	     			
	     		
	     		</td>
	     		<td>
		     		<form:checkbox path="termAndCondition" id="check"/>
		     		<label>I am agreeing that is fun</label>
	     		</td>
	     		<td><form:errors path="termAndCondition" cssClass="error"/></td>
	     
	     </tr>
	     
	     <tr>
	     		<td></td>
	     		<td>
	     			<form:button type="Submit">Calculate</form:button>
	     		<!-- <input type="submit" name="btn" value="calvulate"/> -->
	     		
	     		</td>
	     </tr>
		
		</table>
</form:form>

</div>
		

</body>
</html>