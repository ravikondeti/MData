<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
 <!--  <meta http-equiv="Refresh" content="0; URL=app/main" />-->
 <!--<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" >-->
 <link href="<c:url value="/resources/css/login.css" />" rel="stylesheet"  type="text/css" />
<title>MData Login</title>

</head>
<body>
	<div id="container" >
		
		<div id="header"> 
		
			
			<h1 id="login_header">Welcome To Login Page</h1>
		</div>
		<div id="content"> 
			<form action="login.jsp" method="post">
			<h1>Sign in </h1>
			<div id="divlogin">
				<a></a>
				<div id="login_ele1" class="text_type_class">
				<label for="orgid" class="lbl_cls">ORG ID</label>
				<input type="text" id="orgid" name="orgid" class="login_inp" maxlength="6" size="12" />
				</div>
				
				<div id="login_ele2" class="text_type_class">
				<label for="userid" class="lbl_cls">USER ID</label>
				<input type="text" id="userid" name="userid" class="login_inp" maxlength="6" size="12" />
				</div>
				
				<div id="login_ele3" class="pass_type_class">
				<label for="password" class="lbl_cls">PASSWORD</label>
				<input type="password" id="password" name="password" class="login_inp" maxlength="10" size="12"  />
				</div>
				
				<div id="login_ele4" >
				<input type="submit" id="submit" name="submit" value="Sign in" class="btn_type_class" />
				</div>
			</div>
			
			
			</form>
		</div>
		<div id="footer"> 
		
		</div>	
	
	</div>
</body>
</html>