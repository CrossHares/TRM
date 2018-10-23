<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Request form goes here. 
<table border="2" style="background-color:cyan" cellspacing="4" cellpadding="5">
	<tr>
		<th>Training Request Form ID</th>
		<th>Vertical ID</th>
		<th>Vendor ID</th>
		<th>Training Type ID</th>		
		<th>TRF Project ID</th>
		<th>Technology</th>
		<th>Training Objectives</th>
		<th>Date Requested</th>
		<th>Proposed End Date</th>
		<th>Project Training SPOC</th>
		<th>Approx No. Employees</th>
		<th>Requestor Employee ID</th>
		<th>File Location</th>
		<th>Training Source</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="trm" items="${values}">
		<tr>
			<td>${trm.getTrfID()}</td>
			<td>${trm.getVerID()}</td>
			<td>${trm.getVenID()}</td>
			<td>${trm.getTtID()}</td>
			<td>${trm.getTrfProjectID()}</td>
			<td>${trm.getTechnology()}</td>
			<td>${trm.getTrainingObjectives()}</td>
			<td>${trm.getDateRequested()}</td>
			<td>${trm.getProposedEndDate()}</td>
			<td>${trm.getProjectSPOC()}</td>
			<td>${trm.getAppxEmployees()}</td>
			<td>${trm.getRequestorEmpID()}</td>
			<td>${trm.getFileLocation()}</td>
			<td>${trm.getTrainingSource()}</td>
			<td><a href="">Edit Employee</a></td>
			<td><a href="">Delete Employee</a></td>
		</tr>
	</c:forEach>
	
</table>
<br>
</body>
</html>