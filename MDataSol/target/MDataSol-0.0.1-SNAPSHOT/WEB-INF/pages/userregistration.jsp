<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <!--  <meta http-equiv="Refresh" content="0; URL=app/main" />-->
<link href="<c:url value="/resources/css/userregistration.css" />" rel="stylesheet"  type="text/css" />
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Open+Sans" />
<title>MData Registration</title>

</head>
<body>
	<div id="container" >
		<div id="header"> 
			<h1 id="reg_header">Welcome To User Registration Page</h1>
		</div>
		<div id="content"> 
			<div id="div_org_reg">
				<form:form action="saveUser" method="POST" modelAttribute="user">
					<div id="org_reg1" class="text_type_class">
						 <table>
							<tbody>
								<tr >
									<td class="usr_reg_cls_lbl">
										<label for="usr_id" class="usr_reg_lbl"> User Id</label>
									</td>
									<td>
										<form:input path="indUserId" />
									</td>
								</tr>
								<tr>	
									<td class="usr_reg_cls_lbl">
										<label for="usr_frstname" class="usr_reg_lbl">First Name</label>
									</td>
									<td>
									<form:input path="indUserFirstName" />
									</td>
								</tr>
								<tr>	
									<td class="usr_reg_cls_lbl">
										<label for="usr_lastname" class="usr_reg_lbl">Last Name</label>
									</td>
									<td>
									<form:input path="indUserLastName" />
									</td>
								</tr>
								
								<tr >	
									<td class="usr_reg_cls_lbl" colspan="2">
										<input type="submit" id="usr_submit" value="Submit"> </input>
									</td>
									
								</tr>
			
							</tbody>

						</table>
					</div>
				</form:form>
			</div>
			
	
		</div>
		<div id="footer"> 
		
		</div>	
	
	</div>
</body>
</html>