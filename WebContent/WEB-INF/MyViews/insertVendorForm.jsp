<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Vendor</title>
<%
	if(session.isNew())
	{
		session.putValue("loginMessage", "  ");
	}
%>
</head>
<body>

<center>
	New Vendor Form
	<br>
	<br>
	<form action="saveVendor" >
	<table>
		<tr>
			<td>Vendor Name:</td>
			<td><input type="text" name="venName" required size="20" height="50" /></td>
		</tr>
		<tr>
			<td>Location:</td>
			<td><input type="text" name="venLocation" required size="20" height="50" /></td>
		</tr>
		<tr>
			<td>Address:</td>
			<td><input type="text" name="venAddress" required size="20" height="50" /></td>
		</tr>
		<tr>
			<td>SPOC:</td>
			<td><input type="text" name="venSpoc" required size="20" height="50" /></td>
		</tr>
		<tr>
			<td>Phone:</td>
			<td><input type="text" name="venPhone" required size="20" height="50" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="text" name="venEmail" required size="20" height="50" /></td>
			<td><%= session.getAttribute("loginMessage") %></td>
		</tr>
	</table>
	<br>
	<input type="submit" value="save Vendor" />
</form>
<br><br>

<form action="showAllVendors" >
	<button type="submit" >Back to Vendor Employee</button>
	</form>
</center>

</body>
</html>