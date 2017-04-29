<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> Welcome to student data from</h3>

<form action="Stident-data.jsp">

<label for="firstname"> FirstName</label> <input type="text" id="firstname" name="firstname"/>
<br/><br/>
<label for="lastname">LastName</label><input type="text" id="lastname" name="lastname"/>  
<br/><br/>
<input type="submit" id="submit" value="Submit"></input>
</form>
<br/><br/>
<pre>firstname=${param.firstname}</pre>
<br/><br/>
<pre>lastname=${param.lastname}</pre>

</body>
</html>