<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>Expression(To print some thing user should Expression tag ):</p>
<p>  <%=(2+2) %></p>
<p>The current date time is <%= new java.util.Date() %>></p>

<p>To diclar any variable we should use declaration tag :</p>
<%! int a=6; %> <%=a %>

<% if(a==5){ %>
	<input type="text" value="" name="student name"/>
<%}else{ %>
	<input type="submit" value="ADD" name="btn"/>
<%} %>


<p>jsp action tag :</p><hr>

<!--  object calling by using jsp:useBean ::  -->
<jsp:useBean id="useBean" class="com.mazedexpress.beans.MassageBean" scope="request"></jsp:useBean>

property using from the bean class using jsp:getProperty : 
<jsp:getProperty property="massage" name="useBean"/>
<br>
property using jsp expression after setting message : 
<%= useBean.getMassage()%>
<br>
<jsp:setProperty property="massage" name="useBean" value="I am Mazed"/>
<%= useBean.getMassage()%>
<% useBean.setMassage("Hello Everybody"); %><br>
<%= useBean.getMassage()%>

<a href="studentEntryPage"> Add Student</a>
<br>
</body>
</html>