<%@page import="org.apache.tomcat.util.http.Cookies"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welocme to cookie homepage in JSP</h3>

<%
 String favLang="JAVA";
Cookie[] cookies= request.getCookies();
if(cookies != null){
	
	for(Cookie tempcookie:cookies){
		if("myapp.favoritelanguage".equals(tempcookie.getName())){
			favLang=tempcookie.getValue();
			break;
		}
	}
}
%>

My Favorite Langugae: <%=favLang %>
<br/>
<br/>
<a href="../HTML-FILES/student-cookie-favoriteLanguage.html">set cookie</a>
</body>
</html>