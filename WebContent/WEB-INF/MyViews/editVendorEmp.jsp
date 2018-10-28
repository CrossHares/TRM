<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Vendor Employee</title>
</head>
<body>


<center>
<form:form method="POST" action="editVendorEmployeeSave"> 
	<table>
		<tr>
			<td>Vendor Employee ID: </td>
			<td><form:input path="vEmpId" readonly="true" ></form:input>
		</tr>
		<tr>
			<td>Vendor Company ID: </td>
			<td><form:input path="venId" ></form:input>
		</tr>
		<tr>
			<td>Employee Name: </td>
			<td><form:input path="vEmpName" ></form:input>
		</tr>
		<tr>
			<td>Email: </td>
			<td><form:input path="vEmpEmail" readonly="true" ></form:input>
		</tr>
		<tr>
			<td>Location: </td>
			<td><form:input path="vEmpLocation"></form:input>
		</tr>
		<tr>
			<td>Address: </td>
			<td><form:input path="vEmpAddress" ></form:input>
		</tr>
		<tr>
			<td>Phone: </td>
			<td><form:input path="vEmpPhone" ></form:input>
		</tr>
		
		<tr>
			<td>Tech Specialty: </td>
			<td><form:input path="vEmpSpecialty" ></form:input>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Edit Employee Save" />
			</td>
		</tr>
	</table>
</form:form>
</center>


</body>
</html>