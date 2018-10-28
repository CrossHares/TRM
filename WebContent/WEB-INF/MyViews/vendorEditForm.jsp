<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Vendor</title>
</head>
<body>
<center>
<form:form method="POST" action="editVendorSave"> 
	<table>
		<tr>
			<td>Vendor ID: </td>
			<td><form:input path="venId" readonly="true" ></form:input>
		</tr>
		<tr>
			<td>Name: </td>
			<td><form:input path="venName" ></form:input>
		</tr>
		<tr>
			<td>Location: </td>
			<td><form:input path="venLocation"></form:input>
		</tr>
		<tr>
			<td>Address: </td>
			<td><form:input path="venAddress" ></form:input>
		</tr>
		<tr>
			<td>SPOC: </td>
			<td><form:input path="venSpoc" ></form:input>
		</tr>
		
		<tr>
			<td>Phone: </td>
			<td><form:input path="venPhone" ></form:input>
		</tr>
		<tr>
			<td>Email: </td>
			<td><form:input path="venEmail" readonly="true" ></form:input>
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