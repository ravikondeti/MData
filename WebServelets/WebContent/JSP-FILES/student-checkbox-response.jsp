<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Student name: ${param.firstname} ${param.lastname}
<br/>
<br/>
Student favorite Languages:
<br/>
<ul>
<%
String[] langValues=request.getParameterValues("favoritelanguage");

for(String langValue: langValues){
	out.println("<li>" +langValue +"</li>");
	
}
%>
</ul>

</body>
</html>