<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table border="1">
				<tr>
					<td>Email</td>
					<td>FirstName</td>
					<td>LastName</td>
					<td>Address</td>
					<td>Phone</td>
					<td>Phone</td>
				</tr>
				<tr>
					<td>${student.email}</td>
					<td>${student.name.first_name}</td>
					<td>${student.name.first_name}</td>
					<td>${student.address.city} ${student.address.road_no}</td>
					<td>${student.address.phone[0].country_code } ${student.address.phone[0].main_digit}  </td>
					<td>${student.address.phone[1].country_code } ${student.address.phone[1].main_digit}  </td>
				</tr>
					
		</table>
</body>
</html>