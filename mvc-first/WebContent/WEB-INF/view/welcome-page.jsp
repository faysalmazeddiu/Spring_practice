<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${pagetitle}</title>
</head>
<body>
	<h1 align="center">${pagetitle}</h1>
	<hr>
	<br>
	<div align="center">
		<form action="processorder">
		
				<label for="item-name">Item name</label>
				<input type="text"  name="item_name" value="" placeholder="item name">
				<input type="submit" value="Make order">
		
		
		
		</form>


	</div>


</body>
</html>