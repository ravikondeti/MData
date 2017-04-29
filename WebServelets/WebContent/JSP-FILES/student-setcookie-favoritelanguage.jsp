<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> Setting favorite language cookie</h3>
<%
String newCookieValue= request.getParameter("favoritelanguage");
Cookie cookie= new Cookie("myapp.favoritelanguage", newCookieValue);
cookie.setMaxAge(60*60*24*365);
response.addCookie(cookie);

%>

<p> The coockie value got set successfully </p>
<a href="cookie-homepage.jsp">Back to Homepage</a>

</body>
</html>