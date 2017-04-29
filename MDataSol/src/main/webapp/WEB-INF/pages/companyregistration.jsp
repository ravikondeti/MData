<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <!--  <meta http-equiv="Refresh" content="0; URL=app/main" />-->
  <link href="<c:url value="/resources/css/companyregistration.css" />" rel="stylesheet"  type="text/css" />

<title>MData Registration</title>

</head>
<body>
	<div id="container" >
	<div id="header">
		<h1 id="reg_header">Welcome To Company Registration Page</h1>
	</div>
	<div id="content"> 
			<div id="div_org_reg">
				<form:form action="saveCustomer" method="post" modelAttribute="customer">
					<div id="org_reg1" class="text_type_class">
						 <table>
						 <form:hidden path="indCustomerKy" />
							<tbody>
								<tr >
									<td id="org_reg_id_lbl" class="org_reg_cls_lbl">
										<label for="org_id"> Org Id</label>
									</td>
									<td>
									<form:input path="indCustomerId" />
									
									</td>
								</tr>
								<tr>	
									<td class="org_reg_cls_lbl">
										<label for="org_name"> Org Name</label>
									</td>
									<td>
									<form:input  path="indCustomerName" />
										
									</td>
								</tr>
								<tr>	
									<td class="org_reg_cls_lbl">
										<label for="org_add1"> Org Address1</label>
									</td>
									<td>
									<form:input path="indCustomerAddress1"  />
										
									</td>
								</tr>
								<tr>	
									<td class="org_reg_cls_lbl">
										<label for="org_add2"> Org Address2</label>
									</td>
									<td>
									<form:input path="indCustomerAddress2" />
										
									</td>
								</tr>
								<tr>	
									<td class="org_reg_cls_lbl">
									
										<label for="org_ctry"> Org Country</label>
									</td>
									<td>
									<form:select path="indCustomercountry" >
									<form:option value="">Select</form:option>
									<form:option value="IN"> India</form:option>
									</form:select>
									</td>
								</tr>
								<tr >	
									<td class="org_reg_cls_lbl" colspan="2">
										<input type="submit" id="org_submit" value="Submit" />
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