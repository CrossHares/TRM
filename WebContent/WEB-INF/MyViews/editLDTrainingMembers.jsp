<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit LDT Member</title>
</head>
<body>
<center>
<form:form method="POST" action="saveEditLDTMember"> 
	<table>
		<tr>
			<td>LDT Member ID: </td>
			<td><form:input path="ldtmId" readonly="true" ></form:input>
		</tr>
		<tr>
			<td>Name: </td>
			<td><form:input path="ldtmName" ></form:input>
		</tr>
		<tr>
			<td>Location: </td>
			<td><form:input path="ldtmLocation"></form:input>
		</tr>
		<tr>
			<td>Email: </td>
			<td><form:input path="ldtmEmail" readonly="true"></form:input>
		</tr>
		<tr>
			<td>Phone: </td>
			<td><form:input path="ldtmPhone" ></form:input>
		</tr>
		
		<tr>
			<td>Tech Specialty: </td>
			<td><form:input path="techSpecialty" ></form:input>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Edit Save" />
			</td>
		</tr>
	</table>
</form:form>
</center>


</body>
</html>