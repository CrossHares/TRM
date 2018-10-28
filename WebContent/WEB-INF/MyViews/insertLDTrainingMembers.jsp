<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert LD Training Member</title>
<%
	if(session.isNew())
	{
		session.putValue("loginMessage", "  ");
	}
%>
</head>
<body>

<center>
	New L&D Training Member Form
	<br>
	<br>
	<form action="saveLDTMember" >
	<table>
		<tr>
			<td>LDT Member Name:</td>
			<td><input type="text" name="ldtmName" required size="20" height="50" /></td>
		</tr>
		<tr>
			<td>Location:</td>
			<td><input type="text" name="ldtmLocation" required size="20" height="50" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="text" name="ldtmEmail" required size="20" height="50" /></td>
			<td><%= session.getAttribute("loginMessage") %></td>
		</tr>
		<tr>
			<td>Phone:</td>
			<td><input type="text" name="ldtmPhone" required size="20" height="50" /></td>
		</tr>
		<tr>
			<td>Tech Specialty:</td>
			<td><input type="text" name="techSpecialty" required size="20" height="50" /></td>
		</tr>
	</table>
	<br>
	<input type="submit" value="save LDT Member" />
</form>
<br>
<br>

<form action="showLDTrainingMember" >
	<button type="submit" >Back to L&D Training Members</button>
	</form>
</center>
</center>

</body>
</html>