<%@page import="org.practice.jsp.JavaTestOnJsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Call Java method on JSP</h3>

<%!
JavaTestOnJsp javaObj= new  JavaTestOnJsp();
%>
Getting Text from Java Class:<%=javaObj.makeItLower("Welcome TO JAVA CALL ON JSP!") %>
</body>
</html>