<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>Confirm Training details</h2>
		<form:form method="POST" action="confirmTraining">
			<table>
				<tr>
					<td>TRF ID :</td>
					<td><form:input path="trfID" readonly="true" /></td>
				</tr>
				<tr>
					<td>TRF Project ID :</td>
					<td><form:input path="trfProjectID" readonly="true" /></td>
				</tr>
				<tr>
					<td>Technology :</td>
					<td><form:input path="technology" readonly="true" /></td>
				</tr>
				<tr>
					<td>Date of Request :</td>
					<td><form:input type="date" path="dateRequested" readonly="true" /></td>
				</tr>
				<tr>
					<td>Proposed Location :</td>
					<td><form:input path="location" readonly="true"/></td>
				</tr>
				<tr>
					<td>Proposed Start Date :</td>
					<td><form:input type="date" path="proposedStartDate" readonly="true"/></td>
				</tr>
				<tr>
					<td>Proposed End Date :</td>
					<td><form:input type="date" path="proposedEndDate" readonly="true"/></td>
				</tr>
				<tr>
					<td>Proposed Start Time :</td>
					<td><form:input type="text" path="startTime" readonly="true"/></td>
				</tr>
				<tr>
					<td>Proposed End Date :</td>
					<td><form:input type="text" path="endTime" readonly="true"/></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Confirm Training" /></td>
				</tr>
			</table>
		</form:form>

	</center>
</body>
</html>