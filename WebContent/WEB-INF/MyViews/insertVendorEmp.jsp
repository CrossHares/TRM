<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Vendor Employee</title>
<%
	if(session.isNew())
	{
		session.putValue("loginMessage", " ");
	}
%>
</head>
<body>


<center>
	New Vendor Employee Form
	<br>
	<br>
	<form action="saveVendorEmp" >
	<table>
		<tr>
			<td>Vendor Company ID:</td>
			<td><input type="text" name="venId" required size="20" height="50" /></td>
		</tr>
		<tr>
			<td>Employee Name:</td>
			<td><input type="text" name="vEmpName" required size="20" height="50" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="text" name="vEmpEmail" required size="20" height="50" /></td>
			<td><%= session.getAttribute("loginMessage") %></td>
		</tr>
		<tr>
			<td>Location:</td>
			<td><input type="text" name="vEmpLocation" required size="20" height="50" /></td>
		</tr>
		<tr>
			<td>Address:</td>
			<td><input type="text" name="vEmpAddress" required size="20" height="50" /></td>
		</tr>
		<tr>
			<td>Phone:</td>
			<td><input type="text" name="vEmpPhone" required size="20" height="50" /></td>
		</tr>
		<tr>
			<td>Tech Specialty:</td>
			<td><input type="text" name="vEmpSpecialty" required size="20" height="50" /></td>
		</tr>
	</table>
	<br>
	<input type="submit" value="save Vendor Employee" />
</form>
<br>
<form action="showVendorEmp" >
	<button type="submit" >Back to Vendor Employee</button>
	</form>

</center>


</body>
</html>