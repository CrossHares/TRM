<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table style="border: double;">
	<tr style="font-size: 10">
		<th>TRF_PROJECT_ID</th>
		<th>TRF_TECHNOLOGY</th>
		<th>TRF_DATE_REQUESTED</th>
	</tr>
			<d:forEach var="dash" items="${firstTableValues}">
				<tr>
					<td>${dash.getTrfID()}</td> 
					<td>${dash.getTechnology()}</td>
					<td>${dash.getDateRequested()}</td>
					<td><a href="move/${dash.getTrfID()}">Move</a></td>
				</tr>
			</d:forEach>		
</table>


<table style="border: double;">
	<tr style="font-size: 10">
		<th>TRF_PROJECT_ID</th>
		<th>TRF_TECHNOLOGY</th>
		<th>TRF_DATE_REQUESTED</th>
	</tr>
			<d:forEach var="dash" items="${secondTableValues}">
				<tr>
					<td>${dash.getTrfID()}</td> 
					<td>${dash.getTechnology()}</td>
					<td>${dash.getDateRequested()}</td>
					<td><a href="process/${dash.getTrfID()}">Process the Data</a></td>
				</tr>
			</d:forEach>		
</table>


</body>
</html>